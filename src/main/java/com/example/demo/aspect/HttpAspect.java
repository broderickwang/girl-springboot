package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    public void doB(){
       System.out.println("使用pointcut befor");
       logger.info("使用pointcut befor log");
    }

    @After("log()")
    public void doA(){
        System.out.println("使用pointcut after");
        logger.info("使用pointcut after log");
    }
}
