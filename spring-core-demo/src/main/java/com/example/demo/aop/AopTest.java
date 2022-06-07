package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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
	//当方法符合切点规则不符合环绕通知的规则时候，执行的顺序如下
	//@Before→@AfterRunning(如果有异常→@AfterThrowing)->@After
	//当方法符合切点规则并且符合环绕通知的规则时候，执行的顺序如下
	//@Around→@Before→@AfterRunning(如果有异常→@AfterThrowing)->@After->around后面的部分
	//execution(表达式)
	//
	//表达式：访问修饰符 返回值 包名.包名.包名…类名.方法名(参数列表)
	//标准的表达式写法范例：
	//public void com.aismall.testaop.controller.HelloController.helloAop()
	//
	//访问修饰符可以省略
	//void com.aismall.testaop.controller.HelloController.helloAop()
	//
	//返回值可以使用通配符*，表示任意返回值
	//* com.aismall.testaop.controller.HelloController.helloAop()
	//
	//包名可以使用通配符，表示任意包，但是有几级包，就需要写几个*.
	//* *.*.*.*.HelloController.helloAop()
	//
	//包名可以使用...表示当前包及其子包
	//* *...HelloController.helloAop()
	//
	//类名和方法名都可以使用*来实现通配
	//* *..*.*()
	//参数列表：
	//
	//可以直接写数据类型：
	//
	//基本类型直接写名称 ：例如，int
	//
	//引用类型写包名.类名的方式 ：例如，java.lang.String
	//
	//可以使用通配符*表示任意类型，但是必须有参数
	//
	//可以使用…表示有无参数均可，有参数可以是任意类型
	//
	//全通配写法:* *..*.*(...)
	@Pointcut("execution (* com.example.demo.controller.*.*(..))")
	public void aop(){
	}
	@AfterReturning(pointcut = "aop()", returning = "result")
	public void doAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("AfterReturning " + result);
	}

	@Before("aop()")
	public void doBefore(JoinPoint jp) {
		System.out.println("beforeAdvice...");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		assert attributes != null;
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		System.out.println("URL : " + request.getRequestURL().toString());
		System.out.println("HTTP_METHOD : " + request.getMethod());
		System.out.println("CLASS_METHOD : " + jp);
		System.out.println("ARGS : " + Arrays.toString(jp.getArgs()));
	}

	@AfterThrowing(throwing = "ex", pointcut = "aop()")
	public void throwsEx(JoinPoint jp,Exception ex){
		System.out.println("异常通知：方法异常时执行.....");
		System.out.println("产生异常的方法："+jp);
		System.out.println("异常种类："+ex);
	}

	//环绕通知可以把前面的四种通知都表示出来，而且环绕通知一般单独使用
	//
	//环绕通知的使用：
	//
	//Spring框架为我们提供了一个接口：ProceedingJoinPoint，该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
	//该接口作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
	//增强代码写在调用proceed()方法之前为前置通知，之后为返回通知，写在catch中为异常通知，写在finally中为后置通知
	@Around(value = "aop()")
	public Object doAround (ProceedingJoinPoint pjp) {
		Object rtValue = null;
		try {
			Object[] args = pjp.getArgs();//得到方法执行所需的参数

			System.out.println("通知类中的doAround方法执行了。。前置");

			args[0] = 3;
			//此时我们修改了参数,可以看到其他通知的结果也变
			//是因为遇到了proceed方法 遇到该方法后回去执行相应的函数方法
			//此时会遇到before等等 故其他通知变了
			//而当我们注释掉proceed方法则before等通知也自然不会被触发
			rtValue = pjp.proceed(args);//明确调用切入点方法（切入点方法）

			System.out.println("通知类中的doAround方法执行了。。返回");
			System.out.println("返回通知："+rtValue);

			return rtValue;
		} catch (Throwable e) {
			System.out.println("通知类中的doAround方法执行了。。异常");
			throw new RuntimeException(e);
		} finally {
			System.out.println("通知类中的doAround方法执行了。。后置");
		}
	}

	@After("aop()")
	public void after(JoinPoint jp){
		System.out.println("后置通知：最后且一定执行.....");
	}


	//within
	//within(表达式)：是用来指定类型的，指定类型中的所有方法将被拦截
	//表达式：包名.包名.包名…类名
	//标准的表达式写法范例：
	//com.aismall.testaop.controller.HelloController
	//举例：匹配HelloController类对应对象的所有方法，并且只能是HelloController的对象，不能是它的子对象。
	//within(com.aismall.testaop.controller.HelloController)
	//也可以使用通配符*：匹配com.aismall包及其子包下面的所有类的所有方法。
	//within(com.aismall…*)
	//
	//this
	//SpringAOP是基于代理的，this就代表代理对象，语法是this(type)，当生成的代理对象可以转化为type指定的类型时表示匹配。
	//没有被重写的接口中的方法和对象中独有的方法也可以匹配，匹配不到被重写了的接口中的方法
	//this(com.aismall.testaop.controller.HelloController)匹配生成的代理对象是HelloController类型的所有方法的外部调用
	//
	//target
	//SpringAOP是基于代理的，target表示被代理的目标对象，当被代理的目标对象可以转换为指定的类型时则表示匹配。
	//target(com.aismall.testaop.controller.HelloController) 匹配所有被代理的目标对象能够转化成HelloController类型的所有方法的外部调用。
	//弥补了this匹配的缺口，无论实现的接口中的方法有没有被重写，均可以匹配

	//args:
	//args用来匹配方法参数
	//args() 匹配不带参数的方法
	//args(java.lang.String) 匹配方法参数是String类型的
	//args(…) 带任意参数的方法
	//args(java.lang.String,…) 匹配第一个参数是String类型的，其他参数任意。最后一个参数是String的同理。

	//@annotation:
	//带有相应注解的方法，比如对标有@Transactional注解的方法进行增强
	//@annotation(org.springframework.transaction.annotation.Transactional)

	//@within和@target针对类的注解
	//@annotation针对方法的注解

	//@args:
	//参数带有相应标注的任意方法，比如@Transactional
	//@args(org.springframework.transaction.annotation.Transactional)
	//
	//逻辑运算符
	//表达式可由多个切点函数通过逻辑运算组成
	//基本使用：使用log()方法相当于直接使用上面的表达式
	//PointCut表达式
	//@Pointcut("execution(public * com.aismall.testaop.controller.HelloController.*(..))")
	//PointCut签名
	//public void log(){
	//PointCut中的运算符：PointCut中可以使用&&、||、!运算
	//@Pointcut("execution(public * com.aismall.testaop.controller.HelloController.*(..))")
	//public void cutController(){
	//}
	//
	//@Pointcut("execution(public * com.aismall.testaop.service.UserService.*(..))")
	//public void cutService(){
	//}
	//
	////使用 && 运算符，则cutAll()的作用等同于cutController 和 cutService 之和
	//@Pointcut("cutController() && cutService()")
	//public void cutAll(){
	//}
}
