package com.lishibook.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lishibook.entity.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class ResourceFocusServiceTest {
	
	@Autowired
	private ResourceFocusService resourceFocusService;
	
	@Test
	public void getFocuses(){
		int fromrid = 1;
		
		List<Resource> resources = resourceFocusService.getFocuses(fromrid);
		
		for(Resource resource :resources){
			System.out.println(resource.getName());
		}
	}
}
