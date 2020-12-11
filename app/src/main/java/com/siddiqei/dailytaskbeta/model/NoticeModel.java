package com.siddiqei.dailytaskbeta.model;

public class NoticeModel {
    String title,time,des;

    public NoticeModel() {
    }

    public NoticeModel(String title, String time, String des) {
        this.title = title;
        this.time = time;
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
