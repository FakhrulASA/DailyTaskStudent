package com.siddiqei.dailytaskbeta.model;

public class ClassListModel {
    String name,time,days, teacher;

    public ClassListModel() {
    }

    public ClassListModel(String name, String time, String days, String teacher) {
        this.name = name;
        this.time = time;
        this.days = days;
        this.teacher= teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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
