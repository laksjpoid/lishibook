package com.lishibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.entity.Resource;
import com.lishibook.mapper.ResourceMapper;

@Service
public class ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;
	
	public Resource getResourceByID(int id){
		return resourceMapper.selectByPrimaryKey(id);
	}
	
	//返回条目数
	public int insert(Resource resource){
		return resourceMapper.insertSelective(resource);
	}
	
	public int update(Resource resource){
		return resourceMapper.updateByPrimaryKeySelective(resource);
	}
}
