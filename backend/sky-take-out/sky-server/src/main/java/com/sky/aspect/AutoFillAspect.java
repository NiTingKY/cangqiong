package com.sky.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
自定义切面
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /*
    对那些类哪些方法进行拦截
     */
    @Pointcut("execution(*com.sky.mapper.*.*(..)) && @annotation.AutoFill")
    public void autoFillPointCut() {}

    /*
    before action notice you
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始进行填充");
    }
}
