package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.User;
import com.lishibook.mapper.UserMapper;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.deleteByPrimaryKey(id);
	}

	public int insert(User record){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.insert(record);
	}

	public int insertSelective(User record){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer id){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.selectByPrimaryKey(id);
	}

	public User selectByEmail(String email){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.selectByEmail(email);
	}
	
	public int updateByPrimaryKeySelective(User record){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record){
		UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
		
		return userMapper.updateByPrimaryKey(record);
	}
}