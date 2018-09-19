package com.alan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alan.common.utils.ResponseData;
import com.alan.model.Comments;
import com.alan.service.CommentsManager;

@RestController
@RequestMapping("/news")
public class CommentsControlller {
	
	@Autowired
	private CommentsManager commentsManager;
	
	/**
	 * 查询评论详情
	 * @param view
	 * @return
	 */
	@RequestMapping("/details")
	public ResponseData findOne(String view) {
		ResponseData responseData = null;
		Comments findById = commentsManager.findById(view);
		if (null==findById) {
			responseData = new ResponseData(0, "查无此人！");
			return responseData;
		}
		responseData = new ResponseData(1, "查询成功！");
		responseData.setData(findById);
		return responseData;
	}

}
