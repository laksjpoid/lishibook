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
	 * �ѵ�¼��ת����ҳ��������ʾ login ҳ��
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
	 * �ѵ�¼��ת����ҳ������ִ�е�¼����¼�ɹ�ת����ҳ�����ɹ�ת����½ҳ����ʾ������Ϣ
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String username, @RequestParam("password") String password){
		ModelAndView modelView = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
		
		if(currentUser.isAuthenticated()){//�ѵ�¼
			modelView.setViewName("redirect:/");
			return modelView;
		}
		
		UsernamePasswordToken token;
		try {
			//δ��¼��ִ�е�¼����
			token = new UsernamePasswordToken(username, password);
			currentUser.login(token);
			
			//�� session �д洢��ǰ�û����û���������
			User user = userService.getUserByEmail(username);
			setSessionEmail(currentUser, username);
			setSessionUserName(currentUser, user.getUsername());
		} catch(AuthenticationException e){
			//��¼ʧ��
			modelView.setViewName("login");
			modelView.addObject("loginFail", true);
			return modelView;
		}
		
		modelView.setViewName("redirect:/");

		return modelView;
	}
	
	/**
	 * ִ��ע����ת����ҳ
	 * @return
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return "redirect:/";
	}
}
