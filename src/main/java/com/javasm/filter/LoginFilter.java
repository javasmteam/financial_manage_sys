package com.javasm.filter; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-13 20:27
 * @Version : 1.0
 **/

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"*.html", "*.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //session对象中的userLogin
        Object userLogin = httpServletRequest.getSession().getAttribute("login");
        String requestURI = httpServletRequest.getRequestURI();

        //获取项目发送到服务期的根目录
        String contextPath = httpServletRequest.getContextPath();

        if (userLogin != null || requestURI.contains("login.html") || requestURI.contains("login.jsp")) {
            chain.doFilter(request, response);
        } else {
            //没有登录，就跳转到登陆的页面
            httpServletResponse.sendRedirect(contextPath+"/login.html");
        }

    }
}
