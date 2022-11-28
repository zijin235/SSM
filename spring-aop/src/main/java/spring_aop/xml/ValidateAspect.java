package spring_aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {

    public void beforeMethod(JoinPoint joinPoint) {

        Signature signature=joinPoint.getSignature();
        System.out.println("前置通知");
    }
}
