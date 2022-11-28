import com.Zijin.mapper.UserMapper;
import com.Zijin.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestPage()
    {
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user WHERE is_deleted=0 LIMIT ?
        Page<User> page=new Page<>(1,3);//当前页1，一页3条数据
        userMapper.selectPage(page,null);//没有任何条件查询，进行分页
        System.out.println(page.getRecords());//获取当前页记录
        System.out.println(page.getPages());//获取总页数
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页

    }

    @Test
    public void testSelectPageVo()
    {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPageVo(page, 20);
//获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());

    }

}
