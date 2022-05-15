package com.javasm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h4>javaweb</h4>
 * <p>数据工具类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-04-29 16:53
 * @Version : 1.0
 **/
public class DataUtil {

    public static Integer stringConvertToInteger(String value) {
        return value != null && !"".equals(value) ? Integer.parseInt(value) : null;
    }

    public static Float stringConvertToFloat(String value) {
        return value != null && !"".equals(value) ? Float.parseFloat(value) : null;
    }

    public static Double stringConvertToDouble(String value) {
        return value != null && !"".equals(value) ? Double.valueOf(value) : null;
    }

    public static Boolean stringConvertToBoolean(String value) {
        return value != null && !"".equals(value) ? Boolean.valueOf(value) : null;
    }

    public static Date stringConvertToUtilDateTime(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return value != null && !"".equals(value) ? format.parse(value) : null;
    }

    public static Date stringConvertToUtilDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return value != null && !"".equals(value) ? format.parse(value) : null;
    }


}
