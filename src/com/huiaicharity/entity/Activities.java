package com.huiaicharity.entity;

import java.sql.Timestamp;

public class Activities {
    private int actid;
    private String name;
    private String address;
    private String start_date,end_date;
    private String aid;
    public Activities(){}

    public Activities(int actid, String name, String address, String start_date, String end_date, String aid) {
        this.actid = actid;
        this.name = name;
        this.address = address;
        this.start_date = start_date;
        this.end_date = end_date;
        this.aid = aid;
    }

    public int getActid() {
        return actid;
    }

    public void setActid(int actid) {
        this.actid = actid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        //格式yyyy-MM-dd HH:mm:ss
        this.end_date = end_date;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
