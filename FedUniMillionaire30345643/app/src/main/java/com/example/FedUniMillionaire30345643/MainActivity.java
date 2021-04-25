package com.example.FedUniMillionaire30345643;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Bundle start;
    EditText name;

    DBhelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DBhelper(this);
        Cursor cursor=db.getdataDB();
        if (cursor.getCount()==0){
            name=findViewById(R.id.name);
            findViewById(R.id.start).setOnClickListener(this);
        }else{
            String n=null;
            while(cursor.moveToNext()){
                n=cursor.getString(1);
            }
            Intent intent=new Intent(this,MainActivity2.class);
            intent.putExtra("name",n);
            startActivity(intent);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startmethode();
                break;
        }
    }
    private void startmethode() {
        String n=name.getText().toString();
        if(n.isEmpty()){
            name.setError("Enter your name first");
            name.requestFocus();
            return;
        }
         Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("name",n);
        startActivity(intent);
        finish();
    }
}