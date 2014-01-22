package com.lishibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.dao.ResourceDao;
import com.lishibook.entity.Resource;

@Service
public class ResourceService {
	@Autowired
	private ResourceDao resourceDao;
	
	public Resource getResourceByID(int id){
		return resourceDao.selectByPrimaryKey(id);
	}
}
