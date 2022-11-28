package spring_aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
//切面中需要通过指定的注解将方法标识为通知方法
//@Before：前置通知，在目标对象方法执行之前执行。
//@After:后置通知，在目标对象方法的finally子句中执行
//@AfterReturning:返回通知，在目标对象返回结果之后执行
//@AfterThrowing:异常通知，在目标对象的catch子句中执行

//切入点表达式：设置在标识通知的注解的value属性中execution(* spring_aop.annotation.CalculatorImpl.*(..))
//execution(* spring_aop.annotation.*.*(..))
//第一个*表示任意的访问修饰符和返回值类型。第二个*表示类中的任意方法，..表示任意的参数列表，类的地方也可以用*，表示包下所有的类。包名处也可以用*

//获取连接点的信息
//在通知方法的从参数位置，设置JointPoint类型的参数，就可以获取连接点所对应方法的信息

//重用切入点表达式
//@Pointcut("execution(* spring_aop.annotation.CalculatorImpl.*(..))")
//public void pointCut(){}
//使用方式 @Before("pointCut()")

//切面的优先级：
//可以通过@Order注解的value属性来设置切面的优先级，默认Integer的最大值
//值越小优先级越高


@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {

    //切入点表达式的重用
    @Pointcut("execution(* spring_aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}
//    @Before("execution(public int spring_aop.annotation.CalculatorImpl.add(int,int))")
//    @Before("execution(* spring_aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的方法的签名信息
        Signature signature=joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args=joinPoint.getArgs();
        System.out.println("前置通知  方法"+signature.getName()+"参数:"+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        System.out.println("byebye "+signature.getName()+"执行完毕");

    }
    //要想在返回通知中获取目标对象方法的返回值，只需要通过@Afterreturning注解的returning属性
    //就可以将通知方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturnningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature=joinPoint.getSignature();
        System.out.println("返回通知 "+signature.getName()+",结果:"+result);
    }
//在异常通知中若获取目标对象方法的异常
//只需要通过AfterThrowing注解的throwing属性，就可以将通知方法的某个参数指定为接受目标对象方法出现的异常的参数
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterReturningThrowing(JoinPoint joinPoint,Throwable ex){
        Signature signature =joinPoint.getSignature();
        System.out.println("异常通知"+signature.getName()+ex);
    }

    @Around("pointCut()")
    //环绕对象的方法一定要和目标对象的返回值一致。
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        //表示目标对象的执行
        Object result=null;
        try{
            System.out.println("环绕通知-->前置通知");
            //表示目标对象的执行方法
            result=joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        }catch (Throwable throwable){
            System.out.println("环绕通知-->异常通知");
        } finally{
            System.out.println("环绕通知-->后置通知");

        }
        return result;
    }

}
