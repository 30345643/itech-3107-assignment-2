package com.example.FedUniMillionaire30345643.Models;

public class Option {
    private String choice;
    private String value;

    public Option(String choice, String value){
        this.choice = choice;
        this.value = value;
    }

    public String getChoice() {
        return choice;
    }

    public String getValue() {
        return value;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
