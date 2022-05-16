package com.javasm.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>保存项目路径监听器</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-16 10:24
 * @Version : 1.0
 **/
@WebListener
public class SaveAppPathListener implements ServletRequestListener {

    /**
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //根目录
        String contextPath = request.getContextPath();
        //获取服务器ip
        String localAddress = "0:0:0:0:0:0:0:1".equals(request.getLocalAddr()) ? "localhost" : request.getLocalAddr();
        //获取服务器端口号
        int localPort = request.getLocalPort();
        //拼接地址字符串
        String appPath = "http://" + localAddress + ":" + localPort + contextPath;
        request.setAttribute("appPath", appPath);
    }
}
