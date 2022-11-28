package spring_tran.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_tran.dao.BookDao;
import spring_tran.service.BookService;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookdao;
    @Override
//    @Transactional(
////            timeout=3
////            isolation = Isolation.DEFAULT
////            propagation = Propagation.REQUIRES_NEW
//    )
    public void buyBook(Integer userId,Integer bookId){
        //查询图书的价格
        Integer price=bookdao.getPriceByBookId(bookId);
        //更新图书的库存
        bookdao.updateStock(bookId);
        //更新用户的余额
        bookdao.updateBalance(userId,price);
    }
}
