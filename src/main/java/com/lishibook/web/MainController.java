package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.User;

@Controller
@RequestMapping("/")
public class MainController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * 注意，已登录时显示主页内容需要显示用户相关信息，在任何页面都是如此
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		logger.debug("Enter MainController.main");
		
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			//获取 session 内容
			User user = getSessionUser(currentUser);
			
			modelView.addObject("user", user);
		}
		
		modelView.setViewName("main");
		
		logger.debug("Exit MainController.main");
		return modelView;
	}
}