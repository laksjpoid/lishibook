package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.Resource;
import com.lishibook.entity.User;
import com.lishibook.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(ResourceController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 
	 * @param resourceid
	 * @return
	 */
	@RequestMapping("/{resourceId}")
	public ModelAndView showResource(@PathVariable("resourceId")int resourceid){
		
		logger.debug("Enter ResourceController.showResource");
		
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			//获取 session 内容
			User user = getSessionUser(currentUser);
			
			modelView.addObject("user", user);
		}
		
		modelView.setViewName("resource");
		Resource resource = resourceService.getResourceByID(resourceid);
		modelView.addObject("resource", resource);
		
		logger.debug("Exit ResourceController.showResource");
		return modelView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addResourcePage(){
		logger.debug("Enter ResourceController.addResourcePage");
		
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			User user = getSessionUser(currentUser);
			
			modelView.addObject("user", user);
		}
		
		modelView.setViewName("add_resource");
		
		logger.debug("Exit ResourceController.addResourcePage");
		return modelView;
	}
	
	/**
	 * 增加一个新资源。
	 * 必须提供： name、content、creatorid、lasteditid（这里就是creatorid）
	 * 可选项： description
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addResource(@RequestParam("name") String name, 
			@RequestParam("description") String description,
			@RequestParam("content") String content){
		
		logger.debug("Enter ResourceController.addResource");
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		
		logger.debug("Exit ResourceController.addResource");
		return modelView;
	}
}
