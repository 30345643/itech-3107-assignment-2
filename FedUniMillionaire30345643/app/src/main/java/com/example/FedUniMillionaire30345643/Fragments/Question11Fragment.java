package com.example.FedUniMillionaire30345643.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.FedUniMillionaire30345643.Models.Question;
import com.example.FedUniMillionaire30345643.R;

import java.util.ArrayList;

public class Question11Fragment extends Fragment implements View.OnClickListener {

    ArrayList<Question> questions = new ArrayList<Question>();
    int savings;
    private TextView qName;
    private TextView A, B, won, C, D;
    private Button answerA, answerB, answerC, answerD;

    public Question11Fragment(ArrayList<Question> questions, int savings){

        this.questions = questions;
        this.savings = savings;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question5_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        qName = view.findViewById(R.id.q_name);
        A = view.findViewById(R.id.A);
        B = view.findViewById(R.id.B);
        C = view.findViewById(R.id.C);
        D = view.findViewById(R.id.D);
        answerA = view.findViewById(R.id.answerA);
        answerB = view.findViewById(R.id.answerB);
        answerC = view.findViewById(R.id.answerC);
        answerD = view.findViewById(R.id.answerD);
        view.findViewById(R.id.answerA).setOnClickListener(this);
        view.findViewById(R.id.answerB).setOnClickListener(this);
        view.findViewById(R.id.answerC).setOnClickListener(this);
        view.findViewById(R.id.answerD).setOnClickListener(this);

        String q = questions.get(10).getQ();
        String a = questions.get(10).getOptions().get(0).getValue();
        String b = questions.get(10).getOptions().get(1).getValue();
        String c = questions.get(10).getOptions().get(2).getValue();
        String d = questions.get(10).getOptions().get(3).getValue();
        int balance = 500000;

        qName.append(q+" \n\n balance is "+ balance);
        A.append(a);
        B.append(b);
        C.append(c);
        D.append(d);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answerD:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new SaveEleven(savings))
                        .commit();
                break;
            case R.id.answerC:
            case R.id.answerA:
            case R.id.answerB:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new ResultsFragment(savings))
                        .commit();
                break;
        }
    }
}

