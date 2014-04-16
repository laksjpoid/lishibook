package com.lishibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lishibook.entity.ResourceTopic;
import com.lishibook.mapper.ResourceTopicMapper;

@Service
public class TopicService {
	@Autowired
	private ResourceTopicMapper topicMapper;
	
	public ResourceTopic getTopicByID(int id){
		return topicMapper.selectByPrimaryKey(id);
	}
}
