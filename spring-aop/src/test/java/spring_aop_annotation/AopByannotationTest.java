package spring_aop_annotation;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_aop.annotation.Calculator;
import spring_aop.annotation.CalculatorImpl;

public class AopByannotationTest {
    @Test
    public void testAOPAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator=ioc.getBean(Calculator.class);
        calculator.div(1,1);
    }
}
