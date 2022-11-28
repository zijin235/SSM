package spring_guigu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//factorybean是一个接口，需要创建一个类实现该接口
//其中有三个方法
//getobject（）通过一个对象交给ioc管理
//getobjecttype（）设置所提供对象的类型
//issingleton（）所提供的都对象是否是单例
//当factorybean的实现类配置为bean时，会将当前类中getobject所返回的对象交给ioc容器管理。

public class factoryBeanTest {
    @Test
    public void testfactory(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring_factory.xml");//xml中没有配置，但是利用了factorybean返回的对象。
        User user=ioc.getBean(User.class);
        System.out.println(user);
    }
}
