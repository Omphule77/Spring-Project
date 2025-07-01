package com.aopdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	@Before("execution(public void add*())")
	public void demoBefore() {
		System.out.println("======> I am under Before <=====");
	}
}
