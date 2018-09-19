package com.alan.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.alan.model.Emailinfo;
import com.alan.service.EmailInfoManager;

@Controller
@RequestMapping("/diy")
public class DiyController {
	
	@Autowired
	private EmailInfoManager emailInfoManager;
	
	
	@RequestMapping("/foru")
	public ModelAndView toindex(@RequestParam("view")String view) throws ParseException{
		ModelAndView modelAndView = new ModelAndView("/phone/love/index");
		Emailinfo findById = emailInfoManager.findById(view);
		String[] split = findById.getContent().split("\\n");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < split.length; i++) {
			list.add(split[i]);
		}
		modelAndView.addObject("contents", list);
		//年月日时分秒
		String tmps = findById.getEventid();
		//年
		String year = tmps.substring(0, tmps.indexOf("年")).trim();
		//月
		String month = tmps.substring(tmps.indexOf("年")+1,tmps.indexOf("月")).trim();
		//日
		String day = tmps.substring(tmps.indexOf("月")+1,tmps.indexOf("日")).trim();
		//时
		String hours = tmps.substring(tmps.indexOf("日")+1,tmps.indexOf("时")).trim();
		//分
		String minit = tmps.substring(tmps.indexOf("时")+1,tmps.indexOf("分")).trim();
		//秒
		String second = tmps.substring(tmps.indexOf("分")+1,tmps.indexOf("秒")).trim();
		modelAndView.addObject("year", year);
		modelAndView.addObject("month", month);
		modelAndView.addObject("day", day);
		modelAndView.addObject("hours", hours);
		modelAndView.addObject("minit",minit);
		modelAndView.addObject("second",second);
		modelAndView.addObject("senduser", findById.getSenduser());
		modelAndView.addObject("reciveuser", findById.getReciveuser());
		return modelAndView;
	}

}
