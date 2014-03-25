package com.lishibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.entity.Resource;
import com.lishibook.entity.ResourceFocus;
import com.lishibook.mapper.ResourceFocusMapper;

@Service
public class ResourceFocusService {
	
	@Autowired
	private ResourceFocusMapper resourceFocusMapper;
	
	//返回条目数
	public int insert(ResourceFocus resourceFocus){
		return resourceFocusMapper.insertSelective(resourceFocus);
	}
	
	public List<Resource> getFocuses(int fromrid){
		return resourceFocusMapper.selectFocuses(fromrid);
	}
	
	public int deleteFocus(int focusid){
		return resourceFocusMapper.deleteByPrimaryKey(focusid);
	}
}
