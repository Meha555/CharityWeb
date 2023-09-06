package com.huiaicharity.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
    private int nid;
    private String title;
    private String content;
    private String author;
    private String time;
    private String aid;
    private String media;
    public News(){}
    public String getMedia(){return media;}
    public void setMedia(String media){this.media=media;}
    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
