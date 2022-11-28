package Spring_test.service.impl;

import Spring_test.dao.BookDao;
import Spring_test.service.BookService;
public class BookServiceImpl implements BookService{
    //删除业务层中使用new的方式创建的dao对象
    private BookDao bookDao;
    public void save(){
        System.out.println("book service save....");
        bookDao.save();
    }
    //提供对应的set方法
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }
}
