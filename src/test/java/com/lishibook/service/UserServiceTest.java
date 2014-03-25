package com.lishibook.service;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lishibook.entity.User;
import com.lishibook.utils.EncryptUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class UserServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getUserByEmail() throws NoSuchAlgorithmException{
		logger.debug("进入 TestUserService.getUserByEmail");
		
		String email = "mengtao09@foxmail.com";
		String password = "123456";
		password = EncryptUtils.getMD5(password);
		
		User user = userService.getUserByEmail(email);
		Assert.assertTrue(password.equalsIgnoreCase(user.getPassword()));
		
		logger.debug("Exit TestUserService.getUserByEmail");
	}
}
