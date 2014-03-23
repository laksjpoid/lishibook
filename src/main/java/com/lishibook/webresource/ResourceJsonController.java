package com.lishibook.webresource;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lishibook.service.ResourceService;
import com.lishibook.web.BaseController;

@Controller
@RequestMapping("/resources/resource")
public class ResourceJsonController extends BaseController {

	private static Logger logger = LoggerFactory
			.getLogger(ResourceJsonController.class);

	@Autowired
	private ResourceService resourceService;

	/**
	 * 
	 * @param resourceid
	 * @return
	 */
	@RequestMapping("/{resourceId}")
	@ResponseBody
	public Map<String, Object> testJson() {  
        System.out.println("testJson");  
        Map<String, Object> modelMap = new HashMap<String, Object>();  
        modelMap.put("name", "lfd");  
        modelMap.put("age", "20");  
        return modelMap;  
    }  
}
