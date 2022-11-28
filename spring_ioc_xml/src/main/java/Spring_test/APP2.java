package Spring_test;

import Spring_test.dao.BookDao;
import Spring_test.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP2 {
    public static void main(String[] args){
        //获取IoC容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring_Heima/src/main/resources/applicationContext.xml");
        //获取bean
        BookDao bookDao=(BookDao) ctx.getBean("bookDao");//取出来后是object类型
        bookDao.save();

        BookService bookService=(BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
