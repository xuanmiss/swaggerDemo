package com.miss.swagger_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author miss
 * <p>返回结果封装注解
 * Created by miss on 2018/4/20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public  @interface RestWrapper {

    String code() default "success";
    String message() default "操作成功";
}
