package spring_tran.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_tran.service.BookService;
import spring_tran.service.CheckOutService;
@Service
public class CheckOutserviceImpl implements CheckOutService {
    @Autowired
    private BookService bookService;
    @Override
//    @Transactional
    public void checkout(Integer userId,Integer[] bookIds){
        for(Integer bookId:bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}
