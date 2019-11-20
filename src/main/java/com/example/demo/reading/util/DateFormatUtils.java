package com.example.demo.reading.util;

import java.util.Date;

public class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {

    /**
     * 返回当前时间，精确到日：2010-09-17
     *
     * @return
     */
    public static String curFullDate() {
        return format(new Date(), "yyyy-MM-dd");
    }

    /**
     * 返回当前时间
     *
     * @param pattern
     * @return
     */
    public static String curDateTime(String pattern) {
        return format(new Date(), pattern);
    }

}
