import com.Zijin.mapper.ProductMapper;
import com.Zijin.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLocker {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void testProduct01()
    {
        //小李查询商品价格
        Product productLi=productMapper.selectById(1);
        System.out.println("小李查询商品价格:"+productLi.getPrice());
        //小王查询商品价格
        Product productWang=productMapper.selectById(1);
        System.out.println("小王查询商品价格:"+productWang.getPrice());
        //将商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        productMapper.updateById(productWang);

        //老板查询商品价格
        Product productLB=productMapper.selectById(1);
        System.out.println("老板查询商品价格:"+productLB.getPrice());
    }

    @Test
    public void testConcurrentVersionUpdate()
    {
        //小李取数据
        Product p1=productMapper.selectById(1L);

        //小王取数据
        Product p2 = productMapper.selectById(1L);

        //小李修改 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果：" + result1);

        //小王修改 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果：" + result2);
        if(result2 == 0){
        //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + p3.getPrice());
    }
}
