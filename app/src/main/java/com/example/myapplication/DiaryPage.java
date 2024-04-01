package com.example.myapplication;

import java.time.LocalDate;
import java.util.Date;

public class DiaryPage {
    private String emailUser;

    private LocalDate date;
    private String title;
    private String content;

    public DiaryPage(){}

    public DiaryPage(String emailUser, LocalDate date, String title, String content) {
        this.emailUser = emailUser;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }

    public String getEmailUser() { return emailUser; }

    public LocalDate getDate() { return date; }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    //    public void setTitle(String title){
//        this.title=title;
//
//    }
//
//    public void setContent(String content){
//        this.content=content;
//    }
//    public DiaryPage(String title, String content){
//
//        this.title=title;
//        this.content=content;
//    }
}
