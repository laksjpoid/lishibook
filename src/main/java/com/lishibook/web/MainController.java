package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController extends BaseController{
	
	/**
	 * 注意，已登录时显示主页内容需要显示用户相关信息，在任何页面都是如此
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			//获取 session 内容
			String email = getSessionEmail(currentUser);
			String username = getSessionUserName(currentUser);
			
			modelView.addObject("authenticated", true);
			modelView.addObject("email", email);
			modelView.addObject("username", username);
		}
		
		modelView.setViewName("main");
		
		return modelView;
	}
}