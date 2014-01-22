package com.lishibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.dao.UserDao;
import com.lishibook.entity.User;
import com.lishibook.exception.UserExistException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	//创建新用户，如果 email已注册则抛出异常
	public void register(User user) throws UserExistException{
		User u = this.getUserByEmail(user.getEmail());
		if(u != null){
			throw new UserExistException("User Exist!");
		}else{
			userDao.insertSelective(user);
		}
	}
	
	public User getUserByEmail(String email){
		return userDao.selectByEmail(email);
	}
}
