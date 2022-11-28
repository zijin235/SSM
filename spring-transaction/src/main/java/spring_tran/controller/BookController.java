package spring_tran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_tran.service.BookService;
import spring_tran.service.CheckOutService;
import spring_tran.service.impl.BookServiceImpl;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckOutService checkOutService;
    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }
    public void checkOut(Integer userId,Integer[] bookIds){checkOutService.checkout(userId,bookIds);}
}
