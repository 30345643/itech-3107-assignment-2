package com.example.FedUniMillionaire30345643;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    private TextView results,user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        user = findViewById(R.id.user);
        results = findViewById(R.id.overal_results);
        String name=getIntent().getStringExtra("name");
        int  score=getIntent().getIntExtra("score",0);
        user.setText("have a great day Mr: "+ name);
        results.setText(score +"$");
    }
}