package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.UserLinkRequest;
import com.lishibook.mapper.UserLinkRequestMapper;

@Repository
public class UserLinkRequestDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.deleteByPrimaryKey(id);
	}

	public int insert(UserLinkRequest record){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.insert(record);
	}

	public int insertSelective(UserLinkRequest record){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.insertSelective(record);
	}

	public UserLinkRequest selectByPrimaryKey(Integer id){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserLinkRequest record){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserLinkRequest record){
		UserLinkRequestMapper userLinkRequestMapper = sqlSessionTemplate.getMapper(UserLinkRequestMapper.class);
		
		return userLinkRequestMapper.updateByPrimaryKey(record);
	}
}