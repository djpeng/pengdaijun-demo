package com.pengdaijun.demo.springmvc.generic.util;
//package com.pengdaijun.spring.util;
//
//import java.lang.reflect.Method;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class DomainDaoInterceptor {
//	@Pointcut("execution(* com.pengdaijun.spring.dao..*(..)) and @annotation(org.springframework.stereotype.Repository)")
//	public void daoDefaultConstructorPointcut() {
//	}
//
//	@After("daoDefaultConstructorPointcut()") // 指定拦截器规则；也可以直接把“execution(*
//	public Object Interceptor(ProceedingJoinPoint pjp) {
//		MethodSignature signature = (MethodSignature) pjp.getSignature();
//		Method method = signature.getMethod(); // 获取被拦截的方法
//		String methodName = method.getName(); // 获取被拦截的方法名
//		return null;
//	}
//}
