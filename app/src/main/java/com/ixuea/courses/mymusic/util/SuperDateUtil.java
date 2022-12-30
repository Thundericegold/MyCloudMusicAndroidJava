package com.ixuea.courses.mymusic.util;

import java.util.Calendar;

/**
 * 日期时间工具类
 */
public class SuperDateUtil {

    /**
     * 当前年
     *
     * @return
     */
    public static int currentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
