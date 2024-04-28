package com.example.Aspects;
import com.example.Classes.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public void save(com.example.Classes.Customer))")
    public void logBefore() {
        System.out.println("Before Method");
    }
}
