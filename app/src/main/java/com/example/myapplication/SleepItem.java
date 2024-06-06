package com.example.myapplication;

public class SleepItem {
    private String date;
    private double sleepHours;
    private int scoreSleep;

    public SleepItem(String date, double sleepHours, int scoreSleep) {
        this.date = date;
        this.sleepHours = sleepHours;
        this.scoreSleep = scoreSleep;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(float sleepHours) {
        this.sleepHours = sleepHours;
    }

    public int getScoreSleep() {
        return scoreSleep;
    }

    public void setScoreSleep(int scoreSleep) {
        this.scoreSleep = scoreSleep;
    }
}
