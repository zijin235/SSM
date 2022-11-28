package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*
    Mybatis获取参数值的两种方式：#{}和${}
    1、若mapper接口方法的参数为单个的字面量类型，此时可以通过#{}和${}以任意的内容获取参数值
    一定要注意${}的单引号问题
    #{}本质是预编译，占位符赋值，${}的本质是字符串拼接
    2、若mapper接口方法的参数为多个的字面量类型
    此时 Mybatis会将参数存放在map集合中，以两种方式存储数据
    a>以arg0，arg1。。。为键，以参数为值
    b>以param1，param2.。。为键，以参数为值
    因此只需要通过#{}和${}即可访问相应的值
    3、若mapper接口方法的参数为一个map类型集合的参数，只需要通过#{}和${}即可访问相应的值。
    4、若mapper接口方法的参数为实体类类型的参数
    只需通过#{}和${}即可访问相应的值。
    5、可以再mapper接口方法的参数上设置@Param注解
    此时Mybatis会将这些参数放在map中，以两种方式进行存储
    a、以@Param注解的value属性值为键，以参数为值
    b、以Param1，Param2为键，参数为值

 */
public interface UserMapper {
    User getUserByUserName(String username);//根据用户名查询用户信息
    User checkLogin(String username,String password);//验证登录
    User checkLoginByMap(Map<String,Object> map);
    void insertUser(User user);

    /**
     * 验证登录（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username, @Param("password")String password);

}
