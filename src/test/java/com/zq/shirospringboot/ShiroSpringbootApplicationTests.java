package com.zq.shirospringboot;

import com.zq.shirospringboot.service.UserService;
import com.zq.shirospringboot.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		System.out.println(userService.queryUserByName("zq"));
	}

}
