package com.huiaicharity.entity;

public class Children {
    private String cid;
    private String name;
    private String sex;
    private int age;
    private String region;
    private String situation;
    private String after_help;
    private String tell;
    private String aid;
    public Children(){}
    public Children(String cid, String name, String sex,int age,String region,String situation,String after_help,String tell,String aid){
        this.cid=cid;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.region=region;
        this.situation=situation;
        this.after_help=after_help;
        this.tell=tell;
        this.aid=aid;
    }
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getAfter_help() {
        return after_help;
    }

    public void setAfter_help(String after_help) {
        this.after_help = after_help;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
