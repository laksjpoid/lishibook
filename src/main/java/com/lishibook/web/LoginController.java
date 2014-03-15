package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.User;
import com.lishibook.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginpage(){
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		
		Subject currentUser = SecurityUtils.getSubject();
		
		if(currentUser.isAuthenticated()){
			modelView.setViewName("redirect:/");
		}
		
		return modelView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String username, @RequestParam("password") String password){
		ModelAndView modelView = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
		
		UsernamePasswordToken token;
		try {
			token = new UsernamePasswordToken(username, password);
			currentUser.login(token);
			
			//在 session 中存储当前用户的用户名和姓名
			Session session = currentUser.getSession();
			User user = userService.getUserByEmail(username);
			session.setAttribute("email", username);
			session.setAttribute("name", user.getUsername());
		} catch(AuthenticationException e){
			modelView.setViewName("login");
			modelView.addObject("loginFail", true);
			return modelView;
		}
		
		modelView.setViewName("redirect:/");

		return modelView;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return "redirect:/";
	}
}
