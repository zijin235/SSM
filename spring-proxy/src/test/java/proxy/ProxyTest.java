package proxy;

import org.junit.Test;
import spring_test.proxy.Calculator;
import spring_test.proxy.CalculatorImpl;
import spring_test.proxy.ProxyFactory;

public class ProxyTest {
    /*动态代理有两种
      1、jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口在com.sun.proxy包下
      2、cglib动态代理，最终生成的代理类会继承 目标类，并且和目标类在相同的包下。
     */
    @Test
    public void testProxy(){
//        CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy =(Calculator) proxyFactory.getProxy();//不知道实现的类型，但是可以向上转型，用接口来实现
        proxy.div(1,1);
    }
}
