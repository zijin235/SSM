package com.Zijin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Zijin.pojo.User;
import com.Zijin.service.UserService;
import com.Zijin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 34109
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-11-27 01:22:53
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




