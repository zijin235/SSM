package spring_guigu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    @Test
    public void testIoC(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring_ioc.xml");
//        Student studentone=(Student) ctx.getBean("StudentOne");//通过id获取到的是objec类型
//        Student studentthree=ctx.getBean("StudentThree",Student.class);
//        System.out.println(studentthree);
        Student studentfour=ctx.getBean("StudentFour",Student.class);
        System.out.println(studentfour);
//        ClaSZ classone=ctx.getBean(ClaSZ.class);
//        System.out.println(classone);

    }
    @Test
    public void testDI(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring_ioc.xml");
        Student studentwo=ctx.getBean("StudentTwo",Student.class);
        Student studentOne=ctx.getBean("StudentOne",Student.class);
        Student studentThree=ctx.getBean("StudentThree",Student.class);
        System.out.println(studentwo);
        System.out.println(studentOne);
        System.out.println(studentThree);
    }
}
