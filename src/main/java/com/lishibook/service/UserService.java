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
	
	//�������û������ email��ע�����׳��쳣
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
