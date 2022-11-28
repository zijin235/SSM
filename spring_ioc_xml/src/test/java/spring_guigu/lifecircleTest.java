package spring_guigu;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lifecircleTest {
    /**
     * 1.实例化
     * 2.依赖注入
     * 3.后置处理器的postProcessBeforeInitialization
     * 4.初始化 通过init-method属性指定初始化方法
     * 5.后置处理器的postProcessAfterInitialization
     * 6。ioc容器关闭时销毁。通过destroy-method属性指定销毁的方法。
     * 注意：
     * 若bean的作用域为单例时，生命周期的前三个步骤会在获取ioc容器时执行
     * 若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行。
     */
    @Test
    public void testioc(){
        //ConfigurableApplicationContext 是ApplicationContext的子接口，扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring_lifecircle.xml");
        User user=ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
