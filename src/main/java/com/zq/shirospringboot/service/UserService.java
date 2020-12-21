package com.zq.shirospringboot.service;

import com.zq.shirospringboot.pojo.User;

/**
 * @author zq
 * @create 2020-12-21 15:57
 */
public interface UserService {
    User queryUserByName(String name);
}
