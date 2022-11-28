package springtest;

import ioc_annotation.controller.Usercontroller;
import ioc_annotation.dao.UserDao;
import ioc_annotation.service.UserService;
import ioc_annotation.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*@Component：将类标识为普通组件
  @Controller：将类标识为控制层组件
  @Service：将类标识为业务层组件
  @Repository：将类标识为持久层组件

     通过注解+扫描所配置的bean的id，默认值为类的小驼峰，即首字母为小写的结果。
     @Autowired:实现自动装配功能的注解
     1、@Autowired注解能够标识的位置
        标识在成员变量上面，此时不需要设置成员变量的set方法
        标识在set方法上面
        标识在为当前成员变量赋值的有参构造上面
     2、@Autowired注解的原理
        默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
        若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果，即将要赋值的属性名作为bean的id匹配某个bean为属性赋值
        若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean，且这些bean的id和要赋值的属性的属性名是不一样的。此时抛出异常 nouniquebeandefinitionexception
        此时可以在要赋值的属性上或者set方法上添加注解@qualifier（”“）指定一个bean为属性赋值。通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值。
        注意：若ioc容器中没有任何一个匹配的bean，此时抛出异常NoSuchBeanDefinitionException
        在@Autowired注解中有个属性required 默认值为true，要求必须完成装配，可以将required设置为false，此时能装配则装配，不能装配则使用默认值。


 */
public class IOCByAnnotationTest {
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        Usercontroller usercontroller=ioc.getBean("usercontroller",Usercontroller.class);
//        System.out.println(usercontroller);
//        UserService userService=ioc.getBean("userServiceImpl",UserService.class);
//        System.out.println(userService);
//        UserDao userDao=ioc.getBean("userDaoImpl",UserDao.class);
//        System.out.println(userDao);
        usercontroller.saveUser();

    }
}
