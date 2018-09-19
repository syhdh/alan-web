package com.alan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@RequestMapping("/regist")
	public ModelAndView toregist() {
		ModelAndView modelAndView = new ModelAndView("phone/index");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("phone/login");
		return modelAndView;
	}
	
	//跳转到导航栏
	@RequestMapping("/order")
	public ModelAndView order() {
		ModelAndView modelAndView = new ModelAndView("phone/order");
		return modelAndView;
	}
	

}
