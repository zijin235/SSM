package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser();//添加用户信息
    void updateUser();//修改用户信息
    void deleteUser();//删除用户信息
    User getUserById();//根据id获取用户信息
    List<User> getAllUsers();//获取所有用户信息

}
