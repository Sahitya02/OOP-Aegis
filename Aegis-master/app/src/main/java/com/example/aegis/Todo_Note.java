package com.example.aegis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;

public class Todo_Note extends AppCompatActivity {

    private Toolbar toolbar;
    int noteID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo__note);
        toolbar=findViewById(R.id.grocery_toolbar);
        setSupportActionBar(toolbar);
        String date= DateFormat.getDateInstance().format(new Date());
        getSupportActionBar().setTitle(date);
        EditText editText=(EditText)findViewById(R.id.editText);
        Intent intent=getIntent();
        noteID=intent.getIntExtra("noteId",-1);
        if(noteID!=-1){
            editText.setText(Todo.todo.get(noteID));
        }
        else{
            Todo.todo.add("");
            noteID=Todo.todo.size()-1;
           Todo.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Todo.todo.set(noteID,String.valueOf(s));
                Todo.arrayAdapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.aegis", Context.MODE_PRIVATE);
                HashSet<String> set=new HashSet<String>(Todo.todo);
                sharedPreferences.edit().putStringSet("todo",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_share_diary,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.diary_share):
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, Todo.todo.get(noteID));

                startActivity(Intent.createChooser(share, "Share"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}