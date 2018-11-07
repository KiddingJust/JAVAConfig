package org.kidding.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	//org.kidding.service 에 속한 모든 method에 걸림. 
	@Before("execution(* org.kidding.service.*.*(..))") 
	public void logBefore() {
		
		log.info("-------------------------------");
		log.info("-------------------------------");
		log.info("-------------------------------");
		
	}
	
}
