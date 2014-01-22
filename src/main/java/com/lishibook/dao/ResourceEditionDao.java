package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.ResourceEdition;
import com.lishibook.mapper.ResourceEditionMapper;

@Repository
public class ResourceEditionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.deleteByPrimaryKey(id);
	}

	public int insert(ResourceEdition record){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.insert(record);
	}

	public int insertSelective(ResourceEdition record){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.insertSelective(record);
	}

	public ResourceEdition selectByPrimaryKey(Integer id){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ResourceEdition record){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ResourceEdition record){
		ResourceEditionMapper resourceEditionMapper = sqlSessionTemplate.getMapper(ResourceEditionMapper.class);
		
		return resourceEditionMapper.updateByPrimaryKey(record);
	}
}