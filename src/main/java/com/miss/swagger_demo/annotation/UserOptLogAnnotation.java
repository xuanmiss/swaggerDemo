package com.miss.swagger_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author miss
 * <p>操作记录注解
 * Created by miss on 2018/4/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserOptLogAnnotation {

    String content() default "操作内容";

}
