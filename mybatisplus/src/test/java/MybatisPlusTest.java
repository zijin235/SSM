import com.Zijin.mapper.TestMapper;
import com.Zijin.mapper.UserMapper;
import com.Zijin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testMyBatis(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        TestMapper testMapper=ac.getBean(TestMapper.class);
        testMapper.getAllUser().forEach(user -> System.out.println(user));
    }

    @Test
    public void testMyBatisPlus(){
        //根据id查询用户信息
        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void testInsert(){
        User user=new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@Zijin.com");
        int result=userMapper.insert(user);
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        System.out.println("result"+result);
        System.out.println("id:"+user.getId());
    }

    @Test
    public void testDelete(){
        //通过id删除用户
        int result=userMapper.deleteById(1595659098903306242L);
        //DELETE FROM user WHERE id=?
        System.out.println("result"+result);
    }

    @Test
    public void testDeleteByMap(){
        //根据设置的map集合所设置的条件删除记录
        //DELETE FROM user WHERE name = ? AND age = ?
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        int result=userMapper.deleteByMap(map);
        System.out.println("result"+result);
    }

    @Test
    public void testDeleteBatchIds(){
        //通过多个id批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list=Arrays.asList(1L,2L,3L);
        int result=userMapper.deleteBatchIds(list);
        System.out.println("result"+result);
    }

    @Test
    public void testUpdate(){
        //修改用户信息
        //UPDATE user SET name=?, email=? WHERE id=?
        User user=new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("list@Zijin.com");
        int result =userMapper.updateById(user);
    }

    @Test
    public void testSelect(){
        //根据id查询用户
        //SELECT id,name,age,email FROM user WHERE id=?
        User user=userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectMany(){
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        //根据id批量查询
        List<Long> list=Arrays.asList(1L,2L,3L);
        List<User> users=userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        //根据map查询
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String,Object> map=new HashMap<>();
        map.put("name","jack");
        map.put("age",20);
        List<User> users=userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByList(){
        //查询所有用户信息
        //SELECT id,name,age,email FROM user
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectBySelf(){
        Map<String,Object> map=userMapper.selectMapById(1L);
        System.out.println(map);
    }
}
