package com.example.FedUniMillionaire30345643;

public class UserInfo {
    String name,date, difficully;
    int score;

    public UserInfo(String name, String date, String difficully, int score) {
        this.name = name;
        this.date = date;
        this.difficully = difficully;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDifficully() {
        return difficully;
    }

    public void setDifficully(String difficully) {
        this.difficully = difficully;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
