package com.lishibook.service;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lishibook.entity.User;
import com.lishibook.utils.EncryptUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserService userService;
	
	@Test
	public void getUserByEmail() throws NoSuchAlgorithmException{
		String email = "mengtao09@foxmail.com";
		String password = "123456";
		password = EncryptUtils.getMD5(password);
		
		User user = userService.getUserByEmail(email);
		Assert.assertTrue(password.equalsIgnoreCase(user.getPassword()));
	}
}
