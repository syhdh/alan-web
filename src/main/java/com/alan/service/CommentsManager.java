package com.alan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.mapper.CommentsMapper;
import com.alan.model.Comments;

@Service
public class CommentsManager {
	
	@Autowired
	private CommentsMapper commentsMapper;
	
	
	public Comments findById(String userid) {
		return commentsMapper.selectByPrimaryKey(userid);
	}
	
	

}
