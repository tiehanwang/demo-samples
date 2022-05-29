package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AopTest
 * @Description: AopTest
 * @Author: TIEHAN WANG
 * @Date: 2022/5/28 17:21
 * @Version: v1.0
 */
@Aspect
@Component
public class AopTest {
	@Pointcut("execution (* com.example.demo.controller.*.*(..))")
	public void aop(){
	}
	@AfterReturning(pointcut = "aop()", returning = "result")
	public void doAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("AfterReturning");
	}
}
