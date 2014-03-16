package com.lishibook.web;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.lishibook.service.UserService;

/**
 * 这个类主要处理 session 的get 和 set
 * 如在登录的时候需要存储当前用户的用户名和密码方便以后使用，用户如果登录过了则使用session 中的内容展示页面等。
 * @author mengtao
 *
 */
public class BaseController {
	
	protected static final String SESSION_EMAIL = "emaill";
	
	protected static final String SESSION_USERNAME = "username";
	
	@Autowired
	private UserService userService;
	
	protected void setSessionEmail(Subject user, String email){
		user.getSession().setAttribute(SESSION_EMAIL, email);
	}
	
	protected void setSessionUserName(Subject user, String name){
		user.getSession().setAttribute(SESSION_USERNAME, name);
	}
	
	protected String getSessionEmail(Subject user){
		return (String)user.getSession().getAttribute(SESSION_EMAIL);
	}
	
	protected String getSessionUserName(Subject user){
		return (String)user.getSession().getAttribute(SESSION_USERNAME);
	}
}
