package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			Session session = currentUser.getSession();
			String email = (String) session.getAttribute("email");
			String username = (String) session.getAttribute("name");
			modelView.addObject("authenticated", true);
			modelView.addObject("email", email);
			modelView.addObject("name", username);
		}
		
		modelView.setViewName("main");
		
		return modelView;
	}
}