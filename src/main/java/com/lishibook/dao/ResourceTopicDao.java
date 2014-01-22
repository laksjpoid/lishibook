package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.ResourceTopic;
import com.lishibook.mapper.ResourceTopicMapper;

@Repository
public class ResourceTopicDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.deleteByPrimaryKey(id);
	}

	public int insert(ResourceTopic record){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.insert(record);
	}

	public int insertSelective(ResourceTopic record){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.insertSelective(record);
	}

	public ResourceTopic selectByPrimaryKey(Integer id){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKeySelective(ResourceTopic record){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ResourceTopic record){
		ResourceTopicMapper resourceTopicMapper = sqlSessionTemplate.getMapper(ResourceTopicMapper.class);
		
		return resourceTopicMapper.updateByPrimaryKey(record);
	}
}