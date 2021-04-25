package com.example.FedUniMillionaire30345643;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreActivity extends AppCompatActivity {
    DBhelper db;
    ListView listView;
    ArrayList<UserInfo> arrayList=new ArrayList<>();
    ArrayList<String> arrayid=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        listView=findViewById(R.id.listview);
        db=new DBhelper(this);
        Cursor cursor=db.getdataDB();

        String from=getIntent().getStringExtra("from");
        if (cursor.getCount()==0){
            Toast.makeText(this,"there is no score",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(cursor.moveToNext()){
                String name=cursor.getString(1);
                int score =Integer.parseInt(cursor.getString(2));
                String date=cursor.getString(3);
                String difficult=cursor.getString(4);
                arrayid.add(date);
                Log.d("score","name="+name+"--->difficult"+difficult +"----->date=");
                arrayList.add(new UserInfo(name,date,difficult,score));
            }

            ScoreAdapter adapter=new ScoreAdapter(this,R.layout.listitem,arrayList);
            listView.setAdapter(adapter);
            if (from.equals("sortD")){
                Collections.sort(arrayList, new Comparator<UserInfo>() {
                    @Override
                    public int compare(UserInfo o1, UserInfo o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                });
                adapter.notifyDataSetChanged();
            }
            else if (from.equals("sortS")){
                Collections.sort(arrayList, new Comparator<UserInfo>() {
                    @Override
                    public int compare(UserInfo o1, UserInfo o2) {
                        return String.valueOf(o1.getScore()).compareTo(String.valueOf(o2.getScore()));
                    }
                });
                adapter.notifyDataSetChanged();
            }
            //Collections.sort(arrayid);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s=arrayid.get(position);
                    AlertDialog.Builder builder=new AlertDialog.Builder(ScoreActivity.this);
                    builder.setTitle("Are you sure you want to delete this ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Boolean check=db.deleteDB(s);
                            adapter.notifyDataSetChanged();
                            if (check){

                                Toast.makeText(ScoreActivity.this,"item deleted",Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(ScoreActivity.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.create();
                    builder.show();
                }
            });
        }


    }
}