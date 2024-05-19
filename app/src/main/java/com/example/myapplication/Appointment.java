package com.example.myapplication;

public class Appointment {
    private String category;
    private String date;
    private String type;
    private String adress;


    public Appointment(String category, String date, String type, String adress) {
        this.category = category;
        this.date = date;
        this.type = type;
        this.adress = adress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String isType() {
        return type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
