package com.huiaicharity.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Join {
    private String vid;
    private String actid;
    private String date;
    public Join(){}

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
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
