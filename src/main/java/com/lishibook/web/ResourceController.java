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
import com.lishibook.exception.NoSuchPageException;
import com.lishibook.exception.PermissionException;
import com.lishibook.service.ResourceFocusService;
import com.lishibook.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {

	private static Logger logger = LoggerFactory
			.getLogger(ResourceController.class);

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ResourceFocusService resourceFocusService;
	/**
	 * 
	 * @param resourceid
	 * @return
	 */
	@RequestMapping("/{resourceId}")
	public ModelAndView showResource(@PathVariable("resourceId") int resourceid) throws NoSuchPageException{

		logger.debug("Enter ResourceController.showResource");

		ModelAndView modelView = new ModelAndView();

		modelView.setViewName("resource");
		Resource resource = resourceService.getResourceByID(resourceid);

		if (resource == null) {
			throw new NoSuchPageException();
		}
		modelView.addObject("resource", resource);

		logger.debug("Exit ResourceController.showResource");
		return modelView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addResourcePage() throws PermissionException {
		logger.debug("Enter ResourceController.addResourcePage");

		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}
		modelView.setViewName("add_resource");
		logger.debug("Exit ResourceController.addResourcePage");
		return modelView;
	}

	/**
	 * 增加一个新资源。 必须提供： name、content、creatorid、lasteditid（这里就是creatorid） 可选项：
	 * description
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addResource(@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("content") String content) throws PermissionException {

		logger.debug("Enter ResourceController.addResource");
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		// 只有管理员具有添加资源的权限
		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}

		Resource resource = new Resource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setContent(content);

		User user = getSessionUser(currentUser);
		resource.setCreatorid(user.getId());
		resource.setLasteditid(user.getId());

		resourceService.insert(resource);
		modelView.setViewName("redirect:/resource/" + resource.getId());
		logger.debug("Exit ResourceController.addResource");
		return modelView;
		
	}

	/**
	 * 增加一个新资源。 必须提供： name、content、creatorid、lasteditid（这里就是creatorid） 可选项：
	 * description
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{resourceId}", method = RequestMethod.GET)
	public ModelAndView editResourcePage(
			@PathVariable("resourceId") int resourceid) throws PermissionException{

		logger.debug("Enter ResourceController.editResourcePage");
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}

		Resource resource = resourceService.getResourceByID(resourceid);

		if (resource == null) {
			modelView.setViewName("404");
			return modelView;
		}
		modelView.addObject("resource", resource);
		modelView.setViewName("edit_resource");

		logger.debug("Exit ResourceController.editResourcePage");
		return modelView;
	}

	/**
	 * 编辑一个资源。 必须提供： name、content、creatorid、lasteditid（这里就是creatorid） 可选项：
	 * description
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{resourceId}", method = RequestMethod.POST)
	public ModelAndView editResource(
			@PathVariable("resourceId") int resourceid,
			@RequestParam("name") String name,
			@RequestParam("iconurl") String iconurl,
			@RequestParam("description") String description,
			@RequestParam("content") String content) throws PermissionException{

		logger.debug("Enter ResourceController.editResource");
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		// 只有管理员具有添加资源的权限
		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}
		
		Resource resource = resourceService.getResourceByID(resourceid);
		resource.setName(name);
		resource.setIconurl(iconurl);
		resource.setDescription(description);
		resource.setContent(content);

		User user = getSessionUser(currentUser);
		resource.setLasteditid(user.getId());

		resourceService.update(resource);
		modelView.setViewName("redirect:/resource/" + resource.getId());
		logger.debug("Exit ResourceController.editResource");
		return modelView;
	}
}
