package com.alan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/model")
public class NotesController {
	
	
	/**
	 * 查看简历模板
	 * @param note
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toNote(String note) {
		ModelAndView modelAndView = new ModelAndView("/notes/model");
		return modelAndView;
	}
	

}
