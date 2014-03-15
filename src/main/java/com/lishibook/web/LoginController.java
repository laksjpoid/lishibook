package com.lishibook.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
public class LoginController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 已登录则转到主页，否则显示 login 页面
	 * @return
	 */
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
	
	/**
	 * 已登录则转到主页，否则执行登录，登录成功转到主页，不成功转到登陆页并显示错误消息
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String username, @RequestParam("password") String password){
		ModelAndView modelView = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
		
		if(currentUser.isAuthenticated()){//已登录
			modelView.setViewName("redirect:/");
			return modelView;
		}
		
		UsernamePasswordToken token;
		try {
			//未登录，执行登录操作
			token = new UsernamePasswordToken(username, password);
			currentUser.login(token);
			
			//在 session 中存储当前用户的用户名和姓名
			User user = userService.getUserByEmail(username);
			setSessionEmail(currentUser, username);
			setSessionUserName(currentUser, user.getUsername());
		} catch(AuthenticationException e){
			//登录失败
			modelView.setViewName("login");
			modelView.addObject("loginFail", true);
			return modelView;
		}
		
		modelView.setViewName("redirect:/");

		return modelView;
	}
	
	/**
	 * 执行注销，转到主页
	 * @return
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return "redirect:/";
	}
}
