package com.codingzest.first_spring_app.request_models;

public class MyRequestModel {
    
    private String title;
    private int userId;

    public MyRequestModel(String title, int userId) {
        this.title = title;
        this.userId = userId;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }
}
