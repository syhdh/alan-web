package com.alan.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alan.common.utils.ResponseData;
import com.alan.common.utils.StringUtil;
import com.alan.model.User;
import com.alan.service.UserManager;


@Controller
public class AuthController {
	
	@Autowired
	private UserManager userManager;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@PostMapping("/check")
	@ResponseBody
	public String checkUser(@RequestParam("name")String name,@RequestParam("password")String password) {
		User user = userManager.checkUser(name, password);
		if (null==user) {
			return "error";
		}
		String token = userManager.token(user);
		return token;
	}
	
	@RequestMapping("/phoneuser")
	@ResponseBody
	public String checkPhoneUser(String id,String password,HttpServletRequest request) {
		User queryById = userManager.queryById(id);
		if (queryById!=null&&queryById.getPassword().equals(password)) {
			request.getSession().setAttribute("user", queryById);
			return "y";
		}
		return "n";
	}
	
	@RequestMapping("/checkid")
	@ResponseBody
	public String checkAccount(String userid) {
		User queryById = userManager.queryById(userid);
		if (queryById==null) {
			return "y";
		}
		return "n";
	}
	
	
	
	@GetMapping("/regist")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("regist");
		return modelAndView;
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public ResponseData addUser(User user) {
		if (StringUtil.isNotEmpty(user.getUserid())) {
			if (StringUtil.isEmpty(user.getNickname())) {
				user.setNickname(user.getUserid());
			}
			if (StringUtil.isEmpty(user.getPassword())) {
				user.setPassword("123456");
			}
		}
		ResponseData responseData = null;
		int addUser = userManager.addUser(user);
		if (addUser>0) {
			responseData = new ResponseData(0, "添加用户成功！");
			return responseData;
		}
		return new ResponseData(1, "添加用户失败！");
	}
}
