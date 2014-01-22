package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.UserTopicReply;
import com.lishibook.mapper.UserTopicReplyMapper;

@Repository
public class UserTopicReplyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.deleteByPrimaryKey(id);
	}

	public int insert(UserTopicReply record){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.insert(record);
	}

	public int insertSelective(UserTopicReply record){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.insertSelective(record);
	}

	public UserTopicReply selectByPrimaryKey(Integer id){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserTopicReply record){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(UserTopicReply record){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(UserTopicReply record){
		UserTopicReplyMapper userTopicReplyMapper = sqlSessionTemplate.getMapper(UserTopicReplyMapper.class);
		
		return userTopicReplyMapper.updateByPrimaryKey(record);
	}
}