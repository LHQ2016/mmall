package com.mmall.util;


import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeUtil {

    public static final String STANDARD_FORMAT= "yyyy-MM-dd HH:mm:SS";
    //joda-time
    public static Date strToDate(String dateTImeStr, String formatStr) {
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormat.parseDateTime(dateTImeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date, String formatStr) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }
    public static Date strToDate(String dateTImeStr) {
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormat.parseDateTime(dateTImeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(STANDARD_FORMAT);
        return dateTime.toString(STANDARD_FORMAT);
    }

//    public static void main(String[] args) {
//        System.out.println(DateTimeUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:SS"));
//        System.out.println(DateTimeUtil.strToDate("2018-8-18 17:30:59","yyyy-MM-dd HH:mm:SS"));
//    }//end of main
}
