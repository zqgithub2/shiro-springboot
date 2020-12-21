package com.zq.shirospringboot.service.impl;

import com.zq.shirospringboot.mapper.UserMapper;
import com.zq.shirospringboot.pojo.User;
import com.zq.shirospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zq
 * @create 2020-12-21 15:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
