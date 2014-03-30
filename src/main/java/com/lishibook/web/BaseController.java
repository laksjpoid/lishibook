package com.lishibook.web;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.lishibook.entity.User;
import com.lishibook.service.UserService;

/**
 * 这个类主要处理 session 的get 和 set
 * 如在登录的时候需要存储当前用户的用户名和密码方便以后使用，用户如果登录过了则使用session 中的内容展示页面等。
 * @author mengtao
 *
 */
public class BaseController {
	
	protected static final String SESSION_ID = "sessionId";
	protected static final String SESSION_USER = "user";
	
	@Autowired
	private UserService userService;
	
	protected void setSessionUser(Subject currentUser, User user){
		currentUser.getSession().setAttribute(SESSION_USER, user);
	}
	
	protected User getSessionUser(Subject currentUser){
		return (User)currentUser.getSession().getAttribute(SESSION_USER);
	}
}
