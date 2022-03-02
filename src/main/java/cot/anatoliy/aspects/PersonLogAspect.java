package cot.anatoliy.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonLogAspect {
    @Before("execution(* *..PersonService.readAllPersons(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("try to call method: " + joinPoint.getSignature().toLongString() + joinPoint.getSignature().getName());
    }

    @After("execution(* cot.anatoliy.services.PersonService.readAllPersons(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("successfully call method: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* cot.anatoliy.services.PersonService.readAllPersons(..))")
    public Object logAfter(ProceedingJoinPoint joinPoint) {
        System.out.println("successfully call method: " + joinPoint.getSignature().getName());
        System.out.println("Catch!");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;
    }
}
