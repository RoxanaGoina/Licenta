package com.example.myapplication;

import java.util.Objects;

public class Symptom {
    private String name;
    private String date;

    public Symptom(){}

    public Symptom(String name, String date) {
        this.name = name;
        this.date = date;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Symptom other = (Symptom) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.date, other.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }

}
