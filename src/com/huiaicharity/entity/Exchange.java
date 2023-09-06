package com.huiaicharity.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exchange {
    private String vid;
    private int rid;
    private String date;
    public Exchange(){}
    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date now = new Date();//获得当前时间
        this.date = df.format(now);//将当前时间转换成特定格式的时间字符串
    }
}
