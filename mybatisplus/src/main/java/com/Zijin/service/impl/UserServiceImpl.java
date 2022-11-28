package com.Zijin.service.impl;

import com.Zijin.mapper.UserMapper;
import com.Zijin.pojo.User;
import com.Zijin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
