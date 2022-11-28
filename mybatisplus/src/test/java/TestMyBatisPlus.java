import com.Zijin.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//在Spring的环境中测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMyBatisPlus {
    @Autowired
    private TestMapper testMapper;
    @Test
    public void testMyBatisBySpring(){
        testMapper.getAllUser().forEach(user -> System.out.println(user));
    }
}
