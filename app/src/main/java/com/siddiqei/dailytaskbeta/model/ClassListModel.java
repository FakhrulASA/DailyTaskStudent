package com.siddiqei.dailytaskbeta.model;

public class ClassListModel {
    String name,time,days, teacher,id;

    public ClassListModel() {
    }

    public ClassListModel(String name, String time, String days, String teacher,String id) {
        this.name = name;
        this.time = time;
        this.days = days;
        this.teacher= teacher;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
