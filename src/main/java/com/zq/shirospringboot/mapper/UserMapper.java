package com.zq.shirospringboot.mapper;

import com.zq.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zq
 * @create 2020-12-21 15:39
 */
@Repository
@Mapper
public interface UserMapper {

     User queryUserByName(String name);
}
