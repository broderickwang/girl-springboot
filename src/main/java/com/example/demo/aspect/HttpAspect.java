package com.example.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王成达 on 2017/11/8.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Before("execution(public * com.example.demo.controller.GirlController.getGirls(..))")
    public void doBefore(){
        System.out.println(11111);
    }

    @After("execution(public * com.example.demo.controller.GirlController.getGirls(..))")
    public void doAfter(){
        System.out.println(2222);
    }

    //使用切点
    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doB(JoinPoint joinpoint){
       System.out.println("使用pointcut befor");
       logger.info("使用pointcut befor log");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
       //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
        //类参数
        logger.info("class_args={}",joinpoint.getArgs());
    }

    @After("log()")
    public void doA(){
        System.out.println("使用pointcut after");
        logger.info("使用pointcut after log");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturning(Object object){
        logger.info("returning={}",object.toString());
    }

}
