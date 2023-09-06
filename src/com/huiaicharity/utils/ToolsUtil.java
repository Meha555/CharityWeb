package com.huiaicharity.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolsUtil {
    /**
     * 字符串判空
     * @param s
     * @return boolean
     */
    public static boolean isEmpty(String s){
        if(s==null||"".equals(s))
            return true;
        else return false;
    }

    /**
     * 计算小时长hour
     * @param begin
     * @param end
     * @return hour
     */
    public int calculateHour(Timestamp begin, Timestamp end) {
        //SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = end.getTime();
        long t2 = begin.getTime();
        int hours=(int) ((t1 - t2)/(1000*60*60));
        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
        //String hour=""+hours+"时"+minutes+"分"+second+"秒";
        int hour=hours;
        return hour;
    }

    /**
     * 获取当前时间
     * @return this_monment
     */
    public Timestamp getTime(){
        Date date = new Date();//获得当前时间
        Timestamp this_monment= new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
        return this_monment;
    }
}
