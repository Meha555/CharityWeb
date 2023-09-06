package com.huiaicharity.entity;

public class Info {
    private String uid;
    private String cid;
    private int num;
    private String type;
    private String aid;
    public Info(){}

    public Info(String uid, String cid, int num, String type, String aid) {
        this.uid = uid;
        this.cid = cid;
        this.num = num;
        this.type = type;
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
