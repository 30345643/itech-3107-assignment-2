package com.example.FedUniMillionaire30345643.Models;

import java.util.ArrayList;

public class Question {
    private String Q;
    private ArrayList<Option> options;

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
}
