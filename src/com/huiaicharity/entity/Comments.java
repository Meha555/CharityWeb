package com.huiaicharity.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {
    private String uid;
    private int bid;
    private String date;
    public Comments(){}
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }
    public String getDate() {
        return date;
    }
    public void setDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date now = new Date();//获得当前时间
        this.date = df.format(now);//将当前时间转换成特定格式的时间字符串
    }
}
