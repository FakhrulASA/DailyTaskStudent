package com.siddiqei.dailytaskbeta.model;

public class ShowModel {
    String name;
    String phonename;

    public ShowModel() {

    }
    public String toString(){
        return this.name+"\n"+phonename+'\n';
    }

    public ShowModel(String name, String phonename) {
        this.name = name;
        this.phonename = phonename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonename() {
        return phonename;
    }

    public void setPhonename(String phonename) {
        this.phonename = phonename;
    }

}
