package com.example.FedUniMillionaire30345643.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.FedUniMillionaire30345643.Models.Question;
import com.example.FedUniMillionaire30345643.R;

import java.util.ArrayList;

public class SaveOne extends Fragment implements View.OnClickListener{

    ArrayList<Question> questions = new ArrayList<Question>();
    int savings;

    public SaveOne(ArrayList<Question> questions, int savings){
        this.questions=questions;
        this.savings=savings;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question1_savings_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.saveYes).setOnClickListener(this);
        view.findViewById(R.id.saveNo).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveYes:
                this.savings = 1000;
                //setting the default fragment to be home
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new Question2Fragment(questions, savings))
                        .commit();

            case R.id.saveNo:
                //setting the default fragment to be home
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new Question2Fragment(questions, savings))
                        .commit();
        }
    }
}
