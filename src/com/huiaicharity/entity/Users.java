package com.huiaicharity.entity;

public class Users {
    private String uid;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String address;
    private String is_volunteer;
    private String tell;
    private String pwd;
    private String identity;
    private String aid;
    public Users(){}

    public void setAll(String uid, String name, String sex, int age, String email, String address, String is_volunteer, String tell, String pwd, String identity) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = address;
        this.is_volunteer = is_volunteer;
        this.tell = tell;
        this.pwd = pwd;
        this.identity = identity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIs_volunteer() {
        return is_volunteer;
    }

    public void setIs_volunteer(String isvolunteer) {
        this.is_volunteer = isvolunteer;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
