package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.ResourceTopicReply;
import com.lishibook.mapper.ResourceTopicReplyMapper;

@Repository
public class ResourceTopicReplyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.deleteByPrimaryKey(id);
	}

	public int insert(ResourceTopicReply record){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.insert(record);
	}

	public int insertSelective(ResourceTopicReply record){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.insertSelective(record);
	}

	public ResourceTopicReply selectByPrimaryKey(Integer id){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ResourceTopicReply record){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(ResourceTopicReply record){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(ResourceTopicReply record){
		ResourceTopicReplyMapper resourceTopicReplyMapper = sqlSessionTemplate.getMapper(ResourceTopicReplyMapper.class);
		
		return resourceTopicReplyMapper.updateByPrimaryKey(record);
	}
}