package com.alan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.mapper.FileInfoDAO;
import com.alan.model.FileInfoModel;

@Service
public class OssFileManager{
	
	@Autowired
	private FileInfoDAO fileInfoDAO;
	
	public int addFileInfo(FileInfoModel fileInfo) {
		return fileInfoDAO.insertSelective(fileInfo);
	}
	
	
}
