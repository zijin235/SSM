import com.Zijin.mapper.UserMapper;
import com.Zijin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMyBatisX {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test()
    {
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

}
