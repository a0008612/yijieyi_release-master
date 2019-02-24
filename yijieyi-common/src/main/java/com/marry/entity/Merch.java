package com.marry.entity;

public class Merch {
    private int merch_id;
    private String merch_name;
    private String merch_shname;
    private String merch_cel;
    private String merch_mail;
    private String merch_jobtype;
    private String merch_city;
    private String merch_desc;
    private String studio_id;
    private String inspiration_id;

    public int getMerch_id() {
        return merch_id;
    }

    public void setMerch_id(int merch_id) {
        this.merch_id = merch_id;
    }

    public String getMerch_name() {
        return merch_name;
    }

    public void setMerch_name(String merch_name) {
        this.merch_name = merch_name;
    }

    public String getMerch_shname() {
        return merch_shname;
    }

    public void setMerch_shname(String merch_shname) {
        this.merch_shname = merch_shname;
    }

    public String getMerch_cel() {
        return merch_cel;
    }

    public void setMerch_cel(String merch_cel) {
        this.merch_cel = merch_cel;
    }

    public String getMerch_mail() {
        return merch_mail;
    }

    public void setMerch_mail(String merch_mail) {
        this.merch_mail = merch_mail;
    }

    public String getMerch_jobtype() {
        return merch_jobtype;
    }

    public void setMerch_jobtype(String merch_jobtype) {
        this.merch_jobtype = merch_jobtype;
    }

    public String getMerch_city() {
        return merch_city;
    }

    public void setMerch_city(String merch_city) {
        this.merch_city = merch_city;
    }

    public String getMerch_desc() {
        return merch_desc;
    }

    public void setMerch_desc(String merch_desc) {
        this.merch_desc = merch_desc;
    }

    public String getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(String studio_id) {
        this.studio_id = studio_id;
    }

    public String getInspiration_id() {
        return inspiration_id;
    }

    public void setInspiration_id(String inspiration_id) {
        this.inspiration_id = inspiration_id;
    }

    @Override
    public String toString() {
        return "Merch{" +
                "merch_id=" + merch_id +
                ", merch_name='" + merch_name + '\'' +
                ", merch_shname='" + merch_shname + '\'' +
                ", merch_cel='" + merch_cel + '\'' +
                ", merch_mail='" + merch_mail + '\'' +
                ", merch_jobtype='" + merch_jobtype + '\'' +
                ", merch_city='" + merch_city + '\'' +
                ", merch_desc='" + merch_desc + '\'' +
                ", studio_id='" + studio_id + '\'' +
                ", inspiration_id='" + inspiration_id + '\'' +
                '}';
    }
}
