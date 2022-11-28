package springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_tran.controller.BookController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:txByXml.xml")
public class TxByXml {
    @Autowired
    private BookController bookController;
    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
}
