package com.example.springbootvue.springbootjpa.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: springboot-vue
 * @descripttion: date util
 * @author: jiuson
 * @create: 2019-03-29 14:53:11
 */
public class DateUtil {

    /**
     * 按月推迟或延后时间
     * @param month
     * @return
     */
    public static Date addMonth(int month){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }
}
