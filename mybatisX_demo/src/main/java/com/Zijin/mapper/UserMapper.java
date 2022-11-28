package com.Zijin.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.Zijin.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 34109
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-11-27 01:22:53
* @Entity com.Zijin.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndUserNameByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllByUidOrderByAge(@Param("uid") Long uid);
}




