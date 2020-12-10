package com.siddiqei.dailytaskbeta.model;

public class ClassListModel {
    String name,time,days;

    public ClassListModel() {
    }

    public ClassListModel(String name, String time, String days) {
        this.name = name;
        this.time = time;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
