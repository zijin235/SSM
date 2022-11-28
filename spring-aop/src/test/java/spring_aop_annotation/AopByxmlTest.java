package spring_aop_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_aop.xml.Calculator;

public class AopByxmlTest {
    @Test
    public void testByXml(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator=ioc.getBean(Calculator.class);
        calculator.add(1,1);
    }
}
