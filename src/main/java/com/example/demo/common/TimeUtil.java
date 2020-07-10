package com.example.demo.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {


    public String TimeStampToDateFormat(long timeStamp,String dateFormat){
        SimpleDateFormat simpleDateFormat = null;
        if(dateFormat!=null && !dateFormat.equals("")){
            simpleDateFormat = new SimpleDateFormat(dateFormat);
        }else{
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss");
        }
        Date date = new Date(timeStamp);

        String format = simpleDateFormat.format(date);

        return format;

    }

}
