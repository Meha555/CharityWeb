package com.huiaicharity.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Applications {
    private int appid;
    private String uid;
    private String time;
    private String content;
    private String aid;
    public Applications(){}

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date now = new Date();//获得当前时间
        this.time = df.format(now);//将当前时间转换成特定格式的时间字符串
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
