package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.UserLink;
import com.lishibook.mapper.UserLinkMapper;

@Repository
public class UserLinkDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.deleteByPrimaryKey(id);
	}

	public int insert(UserLink record){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.insert(record);
	}

	public int insertSelective(UserLink record){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.insertSelective(record);
	}

	public UserLink selectByPrimaryKey(Integer id){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserLink record){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserLink record){
		UserLinkMapper userLinkMapper = sqlSessionTemplate.getMapper(UserLinkMapper.class);
		
		return userLinkMapper.updateByPrimaryKey(record);
	}
}