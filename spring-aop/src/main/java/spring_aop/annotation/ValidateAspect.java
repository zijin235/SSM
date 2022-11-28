package spring_aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Pointcut("execution(* spring_aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {

        Signature signature=joinPoint.getSignature();
        System.out.println("前置通知");
    }
}
