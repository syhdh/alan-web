package com.alan.threads;

import java.io.File;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;

import com.alan.common.utils.SendMailAcceUtils;
import com.alan.common.utils.StringUtil;

public class SendInfoForAdmin implements Runnable{
	
	/**
	 * 接收者
	 */
	private String reciverMail;
	
	/**
	 * 邮件标题
	 */
	private String tital;
	
	/**
	 * 邮件内容
	 */
	private String message;
	
	/**
	 * 附件地址
	 */
	private File file;
	
	private HttpServletRequest request;
	
	/**
	 * 邮件工具对象
	 */
	private SendMailAcceUtils sendMailAcceUtils;


	public SendInfoForAdmin(String reciverMail, String tital, String message, String filepath,
			SendMailAcceUtils sendMailAcceUtils,HttpServletRequest request) {
		super();
		this.reciverMail = reciverMail;
		this.tital = tital;
		this.message = message;
		if (StringUtil.isNotEmpty(filepath)) {
			this.file = new File(filepath);
		}else {
			this.file = null;
		}
		this.sendMailAcceUtils = sendMailAcceUtils;
		this.request = request;
	}



	@Override
	public void run() {
		try {
			sendMailAcceUtils.sendMail(reciverMail, tital, message, file, request);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		
	}

}
