package com.example.myapplication;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String email;
    private String name;
    private String CNP;
    private boolean sex;
    private String dateOfBirth;

    private double height;

    private double weight;
    private double IMC;
    private int yearOfStudy;

    private int PHQScore;
    private int GADScore;

    private List<Symptom> symptomps;

    private List<DiaryPage> pages;
    private List<Appointment> appointments;

    private int sleepScore;

    private int sleepHours;
    private int heartBeat;

    public User(String email, String name, String CNP, boolean sex, String dateOfBirth, double height, double weight, double IMC, int yearOfStudy, int PHQScore, int GADScore, List<Symptom> symptomps, List<DiaryPage> pages, List<Appointment> appointments, int sleepScore, int sleepHours, int heartBeat) {
        this.email = email;
        this.name = name;
        this.CNP = CNP;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.IMC = IMC;
        this.yearOfStudy = yearOfStudy;
        this.PHQScore = PHQScore;
        this.GADScore = GADScore;
        this.symptomps = symptomps;
        this.pages = pages;
        this.appointments = appointments;
        this.sleepScore = sleepScore;
        this.sleepHours = sleepHours;
        this.heartBeat = heartBeat;
    }

    public User(){}
    public User(String email, String name, String CNP, boolean sex, String dateOfBirth, double height, double weight, double IMC, int yearOfStudy, int PHQScore, int GADScore, List<Symptom> symptomps, List<DiaryPage> pages, int sleepScore, int sleepHours, int heartBeat) {
        this.email = email;
        this.name = name;
        this.CNP = CNP;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.IMC = IMC;
        this.yearOfStudy = yearOfStudy;
        this.PHQScore = PHQScore;
        this.GADScore = GADScore;
        this.symptomps = symptomps;
        this.pages = pages;
        this.sleepScore = sleepScore;
        this.sleepHours = sleepHours;
        this.heartBeat = heartBeat;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getCNP() {
        return CNP;
    }

    public boolean isSex() {
        return sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getIMC() {
        return IMC;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public int getPHQScore() {
        return PHQScore;
    }

    public int getGADScore() {
        return GADScore;
    }

    public List<Symptom> getSymptomps() {
        return symptomps;
    }

    public List<DiaryPage> getPages() {
        return pages;
    }

    public int getSleepScore() {
        return sleepScore;
    }

    public int getSleepHours() {
        return sleepHours;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setPHQScore(int PHQScore) {
        this.PHQScore = PHQScore;
    }

    public void setGADScore(int GADScore) {
        this.GADScore = GADScore;
    }

    public void setSymptomps(List<Symptom> symptomps) {
        this.symptomps = symptomps;
    }

    public void setPages(List<DiaryPage> pages) {
        this.pages = pages;
    }

    public void setSleepScore(int sleepScore) {
        this.sleepScore = sleepScore;
    }

    public void setSleepHours(int sleepHours) {
        this.sleepHours = sleepHours;
    }

    public void setHeartBeat(int heartBeat) {
        this.heartBeat = heartBeat;
    }
}
