package com.alan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MenuController {

	@RequestMapping("/index")
	public ModelAndView tomain() {
		ModelAndView modelAndView = new ModelAndView("/pager/index");
		return modelAndView;
	}
	
}
