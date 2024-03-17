package com.example.myapplication;

public class HeartRace {
    private Integer heartRace;
    private String data;
    public HeartRace(){}
    public HeartRace(Integer heartRace, String data) {
        this.heartRace = heartRace;
        this.data = data;
    }

    public Integer getHeartRace() {
        return heartRace;
    }

    public void setHeartRace(Integer heartRace) {
        this.heartRace = heartRace;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
