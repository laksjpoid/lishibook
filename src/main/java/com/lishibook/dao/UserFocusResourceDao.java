package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.UserFocusResource;
import com.lishibook.mapper.UserFocusResourceMapper;

@Repository
public class UserFocusResourceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.deleteByPrimaryKey(id);
	}

	public int insert(UserFocusResource record){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.insert(record);
	}

	public int insertSelective(UserFocusResource record){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.insertSelective(record);
	}
	
	public UserFocusResource selectByPrimaryKey(Integer id){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserFocusResource record){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserFocusResource record){
		UserFocusResourceMapper userFocusResourceMapper = sqlSessionTemplate.getMapper(UserFocusResourceMapper.class);
		
		return userFocusResourceMapper.updateByPrimaryKey(record);
	}
}