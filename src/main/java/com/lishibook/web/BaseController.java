package com.lishibook.web;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.lishibook.service.UserService;

/**
 * �������Ҫ���� session ��get �� set
 * ���ڵ�¼��ʱ����Ҫ�洢��ǰ�û����û��������뷽���Ժ�ʹ�ã��û������¼������ʹ��session �е�����չʾҳ��ȡ�
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
