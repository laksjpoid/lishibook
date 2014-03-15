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
}