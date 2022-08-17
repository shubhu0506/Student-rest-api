package com.students.info.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

	final static Logger logger = LoggerFactory.getLogger(AspectConfig.class);
	
	@Before("execution(public * com.students.info.services.*.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+" Started :@Before Advice");
	}
	
	@Before("execution(public * com.students.info.controller.*.*(..))")
	public void logBeforeAllMethodsController(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+" Started :@Before Advice for Controller");
	}
	
	@AfterReturning("execution(public * com.students.info.controller.*.*(..))")
	public void logAfterReturningAllController(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+ " Ended :@After Returning Controller Advice");
	}
	
	@AfterReturning("execution(* com.students.info.services.*.*(..))")
	public void logAfterReturningAll(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+ " Ended :@After Returning Advice");
	}
	
	@After("execution(* com.students.info.services.*.*(..))")
	public void endAll(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+ " Finished :@After Advice");
	}
	
	@After("execution(public * com.students.info.controller.*.*(..))")
	public void endAllController(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getSignature().getName()+ " Finished :@After Controller Advice");
	}
	
	@AfterThrowing(pointcut="execution(* com.students.info.services.StudentService.getAllStudentss(..))",
			throwing="theExc")
	public void afterThrowing(JoinPoint joinPoint,Throwable theExc)
	{
		logger.info(joinPoint.getSignature().getName()+ " Throw");
		logger.info("\n====> The Exception is : "+ theExc);
	}
	
//	@Around("execution(* com.students.info.services.*.*(..))")
//	public void beforeandAfter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
//	{
//		logger.info(proceedingJoinPoint.getSignature().getName()+ " Started Around Advice");
//		proceedingJoinPoint.proceed();
//		logger.info(proceedingJoinPoint.getSignature().getName()+ " Ended Around Advice");
//	}
}