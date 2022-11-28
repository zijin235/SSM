import com.Zijin.mapper.UserMapper;
import com.Zijin.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含a，年龄在20~30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user WHERE is_deleted=0
        // AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        queryWrapper.like("user_name","a")
                        .between("age",20,30)
                                .isNotNull("email");
        List<User> list=userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02()
    {
        //查询用户信息，按照年龄降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByDesc("uid");
        List<User> list=userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03()
    {
        //删除邮箱为null的用户信息
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result=userMapper.delete(queryWrapper);
        System.out.println("result"+result);
    }

    @Test
    public void test04()
    {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE t_user SET user_name=?, email=?
        // WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        queryWrapper.gt("age",20)
                        .like("user_name","a")
                                .or().isNull("email");
        User user=new User();
        user.setName("xiaoming");
        user.setEmail("test@Zijin.com");
        int result=userMapper.update(user,queryWrapper);//第一个参数提供修改的替换参数，后一个参数封装操作
        System.out.println("result:"+result);
    }

    @Test
    public void test05(){
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //lambda中的条件优先执行
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        queryWrapper.like("user_name","a")
//                .gt("age",20)
//                .or()
//                .isNull("email");
        queryWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user=new User();
        user.setName("小红");
        user.setAge(22);
        int result=userMapper.update(user,queryWrapper);
        System.out.println("result:"+result);
        //UPDATE t_user SET user_name=?, age=?
        // WHERE is_deleted=0
        // AND (user_name LIKE ? AND (age > ? OR email IS NULL))
    }

    @Test
    public void test06(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //查询用户的用户名、年龄、邮箱信息
        queryWrapper.select("user_name","age","email");
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        List<Map<String ,Object>> maps= userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07()
    {
        //处理子查询
        //查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid<=100");
        List<User> list=userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user WHERE is_deleted=0
        // AND (uid IN (select uid from t_user where uid<=100))
    }

    @Test
    public void test08()
    {
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //UPDATE t_user SET user_name=?,email=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.like("user_name","a")
                .and(i->i.gt("age",20)
                .or().isNull("email"));
        updateWrapper.set("user_name"," 小黑").set("email","abc@Zijin.com");
        int result=userMapper.update(null,updateWrapper);
        System.out.println("result:"+result);
    }

    @Test
    public void test09()
    {
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)) {
            //判断某个字符串是否不为null,不为空白符，不为空字符串
            queryWrapper.like("user_name", username);
        }
        if(ageBegin!=null){
            queryWrapper.ge("age",ageBegin);
        }
        if(ageEnd!=null){
            queryWrapper.le("age",ageEnd);
        }
        List<User> users=userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user
        // WHERE is_deleted=0 AND (age >= ? AND age <= ?)
    }

    @Test
    public void test10()
    {
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        List<User> users=userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
    }
    @Test
    public void test11()
    {
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users=userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
        //SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
    }

    @Test
    public void test12()
    {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName,"小黑").set(User::getEmail,"abc@zijin.com");
        int result=userMapper.update(null,updateWrapper);
        System.out.println("result:"+result);
        //UPDATE t_user SET user_name=?,email=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
    }


}
