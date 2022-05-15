package com.javasm.util;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>Servlet工具类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-13 19:13
 * @Version : 1.0
 **/
public class ServletUtil {

    public static <T> T requestParamsConvertEntity(Map<String, String[]> parameterMap, Class<T> entityClass) {
        T entity = null;

        try {
            entity = entityClass.newInstance();
            //获取实体类中所有的属性
            Field[] fields = entityClass.getDeclaredFields();
            if (fields != null && parameterMap != null) {
                //获取类中的属性
                for (Field field : fields) {
                    //获取类中的属性名
                    String name = field.getName();
                    //获取map集合中的value
                    String[] values = parameterMap.get(name);
                    if (values != null && values.length > 0) {
                        if (values.length == 1) {
                            //输入的是单个数据
                            String value = values[0];
                            if (value != null && !"".equals(value)) {
                                //暴力破解
                                field.setAccessible(true);
                                //获取属性的数据类型
                                Class<?> type = field.getType();
                                if ("java.lang.Integer".equals(type.getName())) {
                                    Integer integer = DataUtil.stringConvertToInteger(value);
                                } else if ("java.lang.Float".equals(type.getName())) {
                                    Float aFloat = DataUtil.stringConvertToFloat(value);
                                } else {
                                    field.set(entity, value);
                                }
                            }
                        } else {
                            //一个字段对应多个值的时候需要拼接字符串
                            StringBuilder stringBuilder = new StringBuilder("");
                            for (int i = 0; i < values.length; i++) {
                                stringBuilder.append(values[i]);
                                if (i < values.length - 1) {
                                    stringBuilder.append(",");
                                }
                            }
                        }
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public static <T> T jsonConvertToEntity(HttpServletRequest request, Class<T> clazz) {
        String s = null;
        try {
            BufferedReader reader = request.getReader();
            s = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
        String s1 = new String(bytes, StandardCharsets.UTF_8);
        return JSONObject.parseObject(s1, clazz);
    }

    public static <T> List<T> jsonConvertToEntity(String path, Class<T> clazz) {
        ExcelReader excelReader = ExcelUtil.getReader(path);
        return excelReader.readAll(clazz);
    }


}
