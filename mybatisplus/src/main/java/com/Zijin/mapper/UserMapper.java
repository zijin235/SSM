package com.Zijin.mapper;

import com.Zijin.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     */
    Map<String,Object> selectMapById(Long id);
    /**
     * 根据年龄查询用户列表，分页显示
     *@param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位
     * @param age 年龄
     */
    IPage<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
    //@Param的作用就是给参数命名，比如在mapper里面某方法A（int id）
    // 当添加注解后A（@Param("userId") int id）
    // 也就是说外部想要取出传入的id值，只需要取它的参数名userId就可以了。
    // 将参数值传如SQL语句中，通过#{userId}进行取值给SQL的参数赋值。
}
