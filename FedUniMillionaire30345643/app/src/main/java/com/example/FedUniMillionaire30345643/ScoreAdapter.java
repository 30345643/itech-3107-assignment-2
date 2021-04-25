package com.example.FedUniMillionaire30345643;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ScoreAdapter extends ArrayAdapter<UserInfo> {

    private int resource;
    private Context context;
    public ScoreAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserInfo> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        convertView=layoutInflater.inflate(resource,parent,false);

        TextView name=convertView.findViewById(R.id.name1);
        TextView score=convertView.findViewById(R.id.score1);
        TextView date=convertView.findViewById(R.id.date1);
        TextView difficulty=convertView.findViewById(R.id.difficulty1);

        name.setText(getItem(position).getName());
        score.setText(String.valueOf(getItem(position).getScore()));
        date.setText(getItem(position).getDate());
        difficulty.setText(getItem(position).getDifficully());


        return convertView;

    }
}
