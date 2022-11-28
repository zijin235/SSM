package springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_pojo.User;
import java.util.*;


//指定当前类在spring的测试环境中执行，此时就可以通过注入的方式直接获取ioc容器的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql="insert into t_user values(null,?,?,?,?)";
        jdbcTemplate.update(sql,"admin","123",23,"123@123.com");
    }
    @Test
    public void testGetUserById(){
        String sql="select * from t_user where id=?";
        User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),1);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        String sql="select * from t_user";
        List<User> list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        String sql="select count(*) from t_user";
        Integer count=jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.print(count);
    }

}
