package com.lishibook.web;

import java.security.NoSuchAlgorithmException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.utils.EncryptUtils;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginpage(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String username, @RequestParam("password") String password){
		ModelAndView modelView = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
		
		UsernamePasswordToken token;
		try {
			token = new UsernamePasswordToken(username, EncryptUtils.getMD5(password));
			currentUser.login(token);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(AuthenticationException e){
			modelView.setViewName("login");
			modelView.addObject("loginFail", true);
			return modelView;
		}
		
		modelView.setViewName("main");

		return modelView;
	}
}
