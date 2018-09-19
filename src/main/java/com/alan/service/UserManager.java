package com.alan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.common.utils.StringUtil;
import com.alan.mapper.UserDAO;
import com.alan.model.User;

@Service
public class UserManager{

	@Autowired
	private UserDAO userDAO;
	
	public User queryById(String id) {
		return userDAO.selectByPrimaryKey(id);
	}
	
	public int addUser(User user) {
		return userDAO.insertSelective(user);
	}
	
	
	
	public String token(User user) {
		String userid = user.getUserid();
		String password = user.getPassword();
		return StringUtil.encodeByMD5(userid+password);
	}
	
	public User checkUser(String name,String password) {
		return userDAO.findByNameAndPassword(name, password);
	}
	
	
}
