package com.example.aegis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView todo,schedule,grocery,bills,diary;
    private Toolbar toolbar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar=findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");
        todo=(CardView) findViewById(R.id.todo);
        schedule=(CardView) findViewById(R.id.schedule);
        grocery=(CardView) findViewById(R.id.grocery);
        bills=(CardView) findViewById(R.id.bills);
        diary=(CardView) findViewById(R.id.diary);
        todo.setOnClickListener(this);
        schedule.setOnClickListener(this);
        grocery.setOnClickListener(this);
        bills.setOnClickListener(this);
        diary.setOnClickListener(this);
        mAuth= FirebaseAuth.getInstance();
        FirebaseUser mUser=mAuth.getCurrentUser();
        String uID=mUser.getUid();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.todo:
                i=new Intent(this,Todo.class);
                startActivity(i);
                break;
            case R.id.schedule:
                i=new Intent(this,Schedule.class);
                startActivity(i);
                break;
            case R.id.grocery:
                i=new Intent(this,Grocery.class);
                startActivity(i);
                break;
            case R.id.bills:
                i=new Intent(this,Bills.class);
                startActivity(i);
                break;
            case R.id.diary:
                i=new Intent(this,Diary.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case(R.id.logout):
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}