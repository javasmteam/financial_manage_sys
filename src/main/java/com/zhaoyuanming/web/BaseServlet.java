package com.zhaoyuanming.web; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-13 19:45
 * @Version : 1.0
 **/

import com.zhaoyuanming.annotation.ResponseTypeAnnotation;
import com.zhaoyuanming.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class BaseServlet<T> extends HttpServlet {
    private final Class<T> entityClass;

    public BaseServlet() {
        //获取子类的父类及泛型类型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //把type类型转换为下面的接口parameterizedType类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //通过parameterizedType中的方法获取泛型类型(子类中继承父类时指定的类型)
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        //将Type转为class
        entityClass = (Class<T>) actualTypeArguments[0];

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //获取type
        String type = request.getParameter("type");

        try {
            //通过type获取子类中的方法
            Method method = getServletMethod(type);

            if (method != null) {

                //通过method获取参数列表
                Object[] methodParams = getMethodParams(method, request, response);

                //执行method中的方法
                Object result = method.invoke(this, methodParams);

                //将method中的返回值进行响应
                responseRequest(method, result, request, response);
            } else {
                response.sendError(500, "type值错误！");
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    private void responseRequest(Method method, Object result, HttpServletRequest request, HttpServletResponse response) {
        if (result != null){
            //获取返回值的类型
            Class<?> resultClass = result.getClass();
            //获取响应类型的注解
            ResponseTypeAnnotation responseTypeAnnotation = method.getAnnotation(ResponseTypeAnnotation.class);

        }
    }

    /**
     * 通过method获取当前方法需要传递的参数列表
     *
     * @param method
     * @param request
     * @param response
     * @return
     */
    private Object[] getMethodParams(Method method, HttpServletRequest request, HttpServletResponse response) {
        int parameterCount = method.getParameterCount();

        Object[] objects = new Object[parameterCount];

        if (parameterCount > 0) {
            //获取method的参数的类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if ("javax.servlet.http.HttpServletRequest".equals(parameterType.getName()) ||
                        "jakarta.servlet.http.HttpServletRequest".equals(parameterType.getName())) {
                    objects[i] = request;
                } else if ("javax.servlet.http.HttpServletResponse".equals(parameterType.getName()) ||
                        "jakarta.servlet.http.HttpServletResponse".equals(parameterType.getName())) {
                    objects[i] = response;
                } else if (entityClass.getName().equals(parameterType.getName())) {
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    T t = ServletUtil.requestParamsConvertEntity(parameterMap, entityClass);
                    objects[i] = t;
                }
            }
        }
        return objects;
    }

    /**
     * 通过type值获取子类中的method
     *
     * @param methodName
     * @return
     */
    private Method getServletMethod(String methodName) {
        //通过this获取子类class
        Class<? extends BaseServlet> aClass = this.getClass();

        //获取子类中所有的方法，不包括超类，接口中的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();

        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
            }
        }
        return method;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
