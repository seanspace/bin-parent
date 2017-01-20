package com.bin.core.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 把这个类声明为一个切面:
 * 1. 需要把该类放到IOC容器中,再声明为一个切面.
 *
 */
@Aspect
@Component
public class FacadeLoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(FacadeLoggingAspect.class);
	private static final String SYSTEM_NAME = "bin-core";

	/**
	 * 定义一个方法,用于声明切入点表达式.一般此方法中不需要填入其他的代码.
	 */
	@Pointcut("execution(public * com.bin.api.facade..*.*(..))")
	public void declareJoinPointExpression(){

	}
	
	
	@Around(value = "declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		Object result = null ;
		Object[] args = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String methodName = methodSignature.getDeclaringTypeName() + "." + methodSignature.getName();

		try {
			logger.info("[系统] - {}, [调用方法] - {}, [请求参数] - " + JSON.toJSONString(args),
					SYSTEM_NAME,methodName);
			result = joinPoint.proceed() ;
		} catch (Throwable e) {
			logger.error("异常：",e);
			throw new RuntimeException(e) ;
		}
		String time = (System.currentTimeMillis() - startTime) + "ms";
		logger.info("[系统] - {}, [调用方法] - {}, [耗时] - " + time + ", [响应参数] - " + JSON.toJSONString(result),
				SYSTEM_NAME,methodName);
		return result ;
	}
	
	

}
