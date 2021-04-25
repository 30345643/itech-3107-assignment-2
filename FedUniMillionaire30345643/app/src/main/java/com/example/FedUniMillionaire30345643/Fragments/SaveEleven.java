package com.example.FedUniMillionaire30345643.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.FedUniMillionaire30345643.R;

public class SaveEleven extends Fragment implements View.OnClickListener{
    int savings;

    public SaveEleven(int savings){
        this.savings=savings;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question11_savings_fragment, container, false);
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
                this.savings = 1000000;
                //setting the default fragment to be home
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new ResultsFragment(1000000))
                        .commit();
                break;

            case R.id.saveNo:
                //setting the default fragment to be home
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.question_fragment, new ResultsFragment(savings))
                        .commit();
                break;
        }
    }
}

