package spring_guigu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldtest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取ioc容器中的bean
        Helloworld helloworld=(Helloworld)ioc.getBean("Helloworld");
        helloworld.sayhello();
    }

}
