package com.lishibook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.Resource;
import com.lishibook.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/{resourceId}")
	public ModelAndView showResource(@PathVariable("resourceId")int resourceid){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resource");
		Resource resource = resourceService.getResourceByID(resourceid);
		mv.addObject("resource", resource);
		return mv;
	}
}
