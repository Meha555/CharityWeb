package com.huiaicharity.entity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BBS {
    private int bid;
    private String title;
    private String time;
    private String author;
    private String content;
    public BBS(){}
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public void setTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date now = new Date();//获得当前时间
        this.time = df.format(now);//将当前时间转换成特定格式的时间字符串
    }
    public void setTime(String time) {this.time=time;}
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
