package com.siddiqei.dailytaskbeta.model;

public class NoteModel {
    String title, note,id;

    public NoteModel() {
    }

    public NoteModel(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
