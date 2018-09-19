package com.alan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.mapper.EmailinfoMapper;
import com.alan.model.Emailinfo;

@Service
public class EmailInfoManager {
	
	@Autowired
	private EmailinfoMapper emailinfoMapper;
	
	
		
	public Emailinfo findById(String id) {
		Emailinfo selectByPrimaryKey = emailinfoMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	
	public int add(Emailinfo emailinfo) {
		int insert = emailinfoMapper.insert(emailinfo);
		return insert;
	}
	
}
