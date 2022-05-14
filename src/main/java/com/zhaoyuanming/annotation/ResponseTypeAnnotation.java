package com.zhaoyuanming.annotation;

import com.zhaoyuanming.myEnum.ResponseEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>响应方式注解</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-13 18:44
 * @Version : 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseTypeAnnotation {
    //设置默认值
    ResponseEnum responseType() default ResponseEnum.AJAX;

    ResponseEnum value() default ResponseEnum.AJAX;
}
