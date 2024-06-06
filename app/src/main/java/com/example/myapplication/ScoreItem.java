package com.example.myapplication;

public class ScoreItem {
    private String date;
    private double heartRate;

    public ScoreItem(String date, double heartRate) {
        this.date = date;
        this.heartRate = heartRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSleepScore() {
        return heartRate;
    }

    public void setSleepScore(double sleepScore) {
        this.heartRate = sleepScore;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}
