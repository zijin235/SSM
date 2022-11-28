package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通过用户名模糊查询用户信息
 */
public interface SpecialSQLMapper {
    List<User> getUserByLike(@Param("mohu") String mohu);
    /**
     * 根据id批量删除
     */
    void deleteMoreUser(@Param("ids") String ids);
    /**
     *动态设置表名，查询用户信息
     */
    List<User> getUserList(@Param("tableName") String tableName);
    /*
        添加用户信息并获取自增的主键
     */
    void insertUser(User user);
}
