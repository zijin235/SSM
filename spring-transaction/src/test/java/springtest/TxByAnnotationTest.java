package springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_tran.controller.BookController;

/*声明式事务的配置步骤：
 1、在spring配置文件中配置事务管理器
 2、开启事务的注解驱动
 3、在需要的事务管理的方法上添加@Transactional注解，该方法就会被事务管理
 @Transactional可以标识在方法上，可以标识在类上，标识在类上所有的方法都会被事务管理。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:txByXml.xml")
public class TxByAnnotationTest {
    @Autowired
    private BookController bookController;
    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
    @Test
    public void checkOut(){
        bookController.checkOut(1,new Integer[]{1,2});
    }
}
