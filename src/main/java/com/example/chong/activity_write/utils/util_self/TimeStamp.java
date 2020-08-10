package com.example.chong.activity_write.utils.util_self;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

    /**
     * 获取当前日期的字符串
     */
    public static String getCurrentTimeStr(){
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
        Date date = new Date();
        return bartDateFormat.format(date);
    }

    /**
     * 时间戳转换成日期
     */
    private static String stampTransDate(Long timestamp){
        Date date = new Date(timestamp);
        String stringFormat = "yyyy-MM-dd EEE HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringFormat);
        String format = simpleDateFormat.format(date);
        return format;
    }




    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(stampTransDate(l));


    }

}


