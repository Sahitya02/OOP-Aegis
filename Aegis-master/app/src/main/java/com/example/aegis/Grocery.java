package com.example.aegis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Grocery extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        toolbar=findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Grocery List");
        add=findViewById(R.id.add);
        add.setOnClickListener(this);
        }
    @Override
    public void onClick(View v) {
        customdialog();
    }
    private void customdialog(){
        AlertDialog.Builder mydialog=new AlertDialog.Builder(Grocery.this);
        LayoutInflater Inflater=LayoutInflater.from(Grocery.this);
        View myview=Inflater.inflate(R.layout.input,null);
        AlertDialog dialog=mydialog.create();
        dialog.setView(myview);
        EditText item=myview.findViewById(R.id.item);
        EditText quantity=myview.findViewById(R.id.quantity);
        Button save=myview.findViewById(R.id.grocery_save);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String mitem=item.getText().toString().trim();
                String mquantity=quantity.getText().toString().trim();
                if(TextUtils.isEmpty(mitem)){
                    item.setError("Item Name Required");
                    return;
                }
                if(TextUtils.isEmpty(mquantity)){
                    quantity.setError("Quantity Required");
                    return;
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}