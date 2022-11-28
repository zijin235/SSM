package spring_tran.dao;

public interface BookDao {
    Integer getPriceByBookId(Integer bookId);//根据图书的id查询图书的价格

    void updateStock(Integer bookId);//根据图书的id更新图书的存量

    void updateBalance(Integer userId, Integer price);//更新余额
}
