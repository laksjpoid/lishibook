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
	 * ע�⣬�ѵ�¼ʱ��ʾ��ҳ������Ҫ��ʾ�û������Ϣ�����κ�ҳ�涼�����
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser.isAuthenticated()) {
			//��ȡ session ����
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