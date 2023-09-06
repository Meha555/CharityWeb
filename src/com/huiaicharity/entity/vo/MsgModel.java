package com.huiaicharity.entity.vo;

public class MsgModel {//消息通信模型，用来把多个参数封装在一个对象里，方便一次性return
    private boolean code=true;
    private String msg;
    private Object object;
    public MsgModel(){}

    public MsgModel(boolean code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
