package com.lishibook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController extends BaseController{
	
	/**
	 * 注意，已登录时显示主页内容需要显示用户相关信息，在任何页面都是如此
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main"; //user 变量自动通过session 添加了
	}
	
	@RequestMapping(value="/404", method = RequestMethod.GET)
	public String errorpage(){
		return "404";
	}
}