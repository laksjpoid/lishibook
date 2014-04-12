package com.lishibook.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.Resource;
import com.lishibook.exception.NoSuchPageException;
import com.lishibook.service.ResourceFocusService;
import com.lishibook.service.ResourceService;

/**
 * 资源关注页面
 * @author mengtao
 *
 */
@Controller
@RequestMapping("/resource/focus")
public class ResourceFocusController extends BaseController{

	private static Logger logger = LoggerFactory
			.getLogger(ResourceFocusController.class);

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ResourceFocusService resourceFocusService;
	
	@RequestMapping("/{resourceId}")
	public ModelAndView showResourceFocus(@PathVariable("resourceId") int resourceid) throws NoSuchPageException{

		logger.debug("Enter ResourceController.showResource");

		ModelAndView modelView = new ModelAndView();

		modelView.setViewName("resource_focus");
		Resource resource = resourceService.getResourceByID(resourceid);

		if (resource == null) {
			throw new NoSuchPageException();
		}
		modelView.addObject("resource", resource);

		logger.debug("Exit ResourceController.showResource");
		return modelView;
	}
}
