package com.lishibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.entity.User;
import com.lishibook.exception.UserExistException;
import com.lishibook.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	//创建新用户，如果 email已注册则抛出异常
	public void register(User user) throws UserExistException{
		User u = this.getUserByEmail(user.getEmail());
		if(u != null){
			throw new UserExistException("User Exist!");
		}else{
			userMapper.insertSelective(user);
		}
	}
	
	public User getUserByEmail(String email){
		return userMapper.selectByEmail(email);
	}
}