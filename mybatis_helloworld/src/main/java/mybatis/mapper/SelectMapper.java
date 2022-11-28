package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /*
        若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值
        否则会抛出异常TOOManyResultsException
        若sql语句查询的结果为1条时，此时可以用实体类类型或list集合类型作为方法的返回值
     */
    /*
        根据id查询用户信息
     */
    User getUserById(@Param("id")Integer Id);
    /*
        查询所有用户
     */
    List<User> getAllUser();
    /**
     * 查询用户的总数量
     */
    Integer Count();
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);//根据id查询用户信息映射为map集合
    /*
        查询所有的用户信息为map集合
        若查询的数据有多条时，并且要将每条数据转换为map集合
        此时有两种解决方案：
        1、将mapper接口方法的返回值设置为泛型是map的list集合
        2、可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey将查询的某个字段
        的值作为大的map的键
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
