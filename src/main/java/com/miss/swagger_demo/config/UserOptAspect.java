package com.miss.swagger_demo.config;

import com.miss.swagger_demo.annotation.UserOptLogAnnotation;
import com.miss.swagger_demo.service.UserOptLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author miss
 * <p>用户操作记录切面类
 * Created by miss on 2018/4/23
 */

@Aspect
@Component
public class UserOptAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserOptAspect.class);

    @Autowired
    private UserOptLogService userOptLogService;

    @Pointcut("execution(public * com.miss.swagger_demo.service.*.*(..))")
    public void weblog(){}

    @AfterReturning("weblog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable
    {
        logger.debug("开始执行日志记录");
        //获得切面当中方法签名
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //获得签名方法
        Method method = methodSignature.getMethod();
        //获得在方法上面的注解
        UserOptLogAnnotation userOptLogAnnotation =  method.getAnnotation(UserOptLogAnnotation.class);
        if(userOptLogAnnotation == null) return;
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        request.getSession().getId()
        userOptLogService.doLog(request.getSession().getId(),userOptLogAnnotation.content());
        logger.debug("日志记录完成");
    }



}
