package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.Resource;
import com.lishibook.mapper.ResourceMapper;

@Repository
public class ResourceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.deleteByPrimaryKey(id);
	}

	public int insert(Resource record){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.insert(record);
	}

	public int insertSelective(Resource record){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.insertSelective(record);
	}

	public Resource selectByPrimaryKey(Integer id){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Resource record){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Resource record){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Resource record){
		ResourceMapper resourceMapper = sqlSessionTemplate.getMapper(ResourceMapper.class);
		
		return resourceMapper.updateByPrimaryKey(record);
	}
}