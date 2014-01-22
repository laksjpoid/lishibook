package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.ResourceRelation;
import com.lishibook.mapper.ResourceRelationMapper;

@Repository
public class ResourceRelationDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int deleteByPrimaryKey(Integer id){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.deleteByPrimaryKey(id);
	}

	public int insert(ResourceRelation record){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.insert(record);
	}

	public int insertSelective(ResourceRelation record){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.insertSelective(record);
	}

	public ResourceRelation selectByPrimaryKey(Integer id){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ResourceRelation record){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ResourceRelation record){
		ResourceRelationMapper resourceRelationMapper = sqlSessionTemplate.getMapper(ResourceRelationMapper.class);
		
		return resourceRelationMapper.updateByPrimaryKey(record);
	}
}