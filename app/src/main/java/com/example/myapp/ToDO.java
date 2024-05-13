package com.example.myapp;

public class ToDO {
    private int id;
    private String title, dates,des;

    public ToDO() {
    }

    public ToDO(int id, String title, String dates, String des) {
        this.id = id;
        this.title = title;
        this.dates = dates;
        this.des = des;
    }

    public ToDO(String title, String dates, String des) {
        this.title = title;
        this.dates = dates;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
