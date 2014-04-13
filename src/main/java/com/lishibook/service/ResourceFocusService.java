package com.lishibook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public boolean exists(int fromid, int toid){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fromid", fromid);
		map.put("toid", toid);
		
		ResourceFocus focus = resourceFocusMapper.getFocus(map);
		if(focus!=null){
			return true;
		}
		return false;
	}
}
