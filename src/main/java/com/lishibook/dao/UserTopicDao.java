package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.UserTopic;
import com.lishibook.mapper.UserTopicMapper;

@Repository
public class UserTopicDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.deleteByPrimaryKey(id);
	}

	public int insert(UserTopic record){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.insert(record);
	}

	public int insertSelective(UserTopic record){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.insertSelective(record);
	}

	public UserTopic selectByPrimaryKey(Integer id){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserTopic record){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(UserTopic record){
		UserTopicMapper userTopicMapper = sqlSessionTemplate.getMapper(UserTopicMapper.class);
		
		return userTopicMapper.updateByPrimaryKey(record);
	}
}