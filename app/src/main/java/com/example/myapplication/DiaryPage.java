package com.example.myapplication;

public class DiaryPage {
    private String title;
    private String content;

    public DiaryPage(){}

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setTitle(String title){
        this.title=title;

    }

    public void setContent(String content){
        this.content=content;
    }
    public DiaryPage(String title, String content){

        this.title=title;
        this.content=content;
    }
}
