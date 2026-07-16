package com.zeus.common.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ServiceLoggerAdvice {
	
	//target = 목표 com.zeus.service.BoardServiceimpl
	//joinpoint = 멤버함수(모든함수를 조인포인트대상자 지정)=> insert, update, delete, select, list,search * *(..)
	//@Before("execution(* com.zeus.service.BoardService*.*(..))")
	//Advice
	//public void starLog(JoinPoint jp) {
	//log.info("********start Log*********");
	//log.info("********start Log*********"+jp.getSignature());
	//log.info("********start Log*********"+Arrays.toString(jp.getArgs()));
	
	
	//@AfterReturning(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", returning = "result")
	//public void logReturning(JoinPoint jp, Object result) {
	//	log.info("********logReturning*********");
	//	log.info("********logReturning*********"+jp.getSignature());
	//	log.info("********logReturning*********"+ result);
		
	//}
	
	@AfterThrowing(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", throwing = "e")
	public void logException(JoinPoint jp, Exception e) {
		log.info("********logException*********");
		log.info("********logException*********"+jp.getSignature());
		log.info("********logException*********"+ e);
		
	}
	
	//@After( "execution(* com.zeus.service.BoardService*.*(..))")
	//public void endlog(JoinPoint jp) {
	//	Date date = new Date();
	//	log.info("********endlog*********"+date.toString());
	//	log.info("********logException*********"+jp.getSignature());
	//	log.info("********logException*********"+Arrays.toString(jp.getArgs()));
	//}
 @Around( "execution(* com.zeus.service.BoardService*.*(..))")
 public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
	 //1. 시간을 가져온다.
	 long starttime = System.currentTimeMillis();
	//2.insert, update, delete, select, list,search
	 log.info("********timelog*********"+pjp.getSignature());
	 log.info("********timelog*********"+Arrays.toString(pjp.getArgs()));
	 Object result = pjp.proceed();
	//3. 종료시간 설정
     long stopTime = System.currentTimeMillis();
     log.info("***>> timelog:"+ pjp.getSignature().getName() +"=>" +(stopTime - starttime));
	 
	 return result;
	 
 }
	
			
	}
