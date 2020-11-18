package com.example.aegis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView todo,schedule,grocery,bills,diary;
    private Toolbar toolbar;
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
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.todo:
                i=new Intent(this,Todo.class);
                break;
            case R.id.schedule:
                i=new Intent(this,Schedule.class);
                break;
            case R.id.grocery:
                i=new Intent(this,Grocery.class);
                break;
            case R.id.bills:
                i=new Intent(this,Bills.class);
                break;
            case R.id.diary:
                i=new Intent(this,Diary.class);
                break;
            default:
                break;
        }

    }
}