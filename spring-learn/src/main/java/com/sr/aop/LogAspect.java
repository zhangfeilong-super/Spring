package com.sr.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class LogAspect {

	@Pointcut("execution(* com.sr.aop.Calculate.*(..))")
	public void pointCut(){}


	@Before(value = "pointCut()")
	public void methodBefore(JoinPoint joinPoint)throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+ methodName + "】的<前置通知>，入参"+ Arrays.asList(joinPoint.getArgs()));
	}



	@After(value = "pointCut()")
	public void methodAfter(JoinPoint joinPoint)throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+ methodName + "】的<后置通知>，入参"+ Arrays.asList(joinPoint.getArgs()));
	}

	@AfterReturning(value = "pointCut()",returning = "result")
	public void methodReturning(JoinPoint joinPoint,Object result)throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+ methodName + "】的<返回通知>，入参"+ Arrays.asList(joinPoint.getArgs()));
		System.out.println(result);
	}

	@AfterThrowing(value = "pointCut()")
	public void methodAfterThrowing(JoinPoint joinPoint)throws Throwable{
		System.out.println("joinPoint----:"+joinPoint);
		System.out.println("joinPoint.getSignature()---:"+joinPoint.getSignature());
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+ methodName + "】的<异常通知>，入参"+ Arrays.asList(joinPoint.getArgs()));
	}

}
