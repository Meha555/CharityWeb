package com.huiaicharity.entity;

public class Projects {
    private int pid;
    private String name;
    private String organizer;
    private String start_date,end_date;
    private String aid;
    public Projects(){}

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        //格式yyyy-MM-dd HH:mm:ss
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
