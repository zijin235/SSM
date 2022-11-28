package Spring_test;

import Spring_test.service.BookService;
import Spring_test.service.impl.BookServiceImpl;
public class App {
    public static void main(String[] args){
        BookService bookService=new BookServiceImpl();
        bookService.save();
    }
}
