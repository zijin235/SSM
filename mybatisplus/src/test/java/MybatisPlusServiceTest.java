import com.Zijin.pojo.User;
import com.Zijin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testGetCount(){
        //查询总记录数
        //SELECT COUNT( * ) FROM user
        long count=userService.count();
        System.out.println("总记录数:"+count);
    }

    @Test
    public void testSaveBatch(){
        // SQL长度有限制，海量数据插入单条SQL无法实行，
// 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users=new ArrayList<>();
        for(int i=0;i<5;i++){
            User user =new User();
            user.setName("cw"+i);
            user.setAge(20+i);
            users.add(user);
        }

        userService.saveBatch(users);
    }
}
