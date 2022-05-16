package com.javasm.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:14
 * @description:
 */
public class BaseUtil {
    /**
     * 将请求数据转换为Bean对象
     *
     * @param req   http请求对象
     * @param clazz Bean对象Class对象
     * @param <T>   Bean对象
     * @return Bean对象, 当转换失败时返回null值
     */
    public static <T> T readBean(HttpServletRequest req, Class<T> clazz) {
        BufferedReader reader = null;
        T t = null;
        try {
            reader = req.getReader();
            String s = reader.readLine();
            t = JSON.parseObject(s, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 将响应对象转换为JSON数据格式进行响应
     * @param resp 响应对象
     * @param o    响应数据
     * @return     发送是否成功 -1:失败 1:成功
     */
    public static Integer sendData(HttpServletResponse resp, Object o) {
        String sendStr = JSON.toJSONString(o);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = null;

        try {
            writer = resp.getWriter();
            writer.write(sendStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            return -1;
        }
        return 1;
    }
}
