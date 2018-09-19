package com.alan.web;

import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alan.common.utils.ResponseData;
import com.alan.common.utils.SendMailAcceUtils;
import com.alan.common.utils.StringUtil;
import com.alan.model.Emailinfo;
import com.alan.service.EmailInfoManager;

@Controller
@RequestMapping("/sendCode")
public class EmailInfoController {
	
	@Autowired
	private EmailInfoManager emailInfoManager;
	
	/**
	 * 邮件
	 */
	@Autowired
	private SendMailAcceUtils sendMailAcceUtils;
	
	
	@RequestMapping("/table")
	public ModelAndView tableIndex() {
		ModelAndView modelAndView = new ModelAndView("table/foru");
		return modelAndView;
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public ResponseData creation(Emailinfo emailinfo,HttpServletRequest request) {
		//TODO 发邮件通知自己
		try {
			sendMailAcceUtils.sendMail("shaoyanghui_dh@163.com", "来客访问提醒！", emailinfo.toString(), null, request);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		ResponseData responseData = null;
		boolean flag = true;
		if (StringUtil.isEmpty(emailinfo.getSenduser())) {
			flag = false;
		}
		if (StringUtil.isEmpty(emailinfo.getReciveuser())) {
			flag = false;
		}
		if (StringUtil.isEmpty(emailinfo.getSendemail())) {
			flag = false;
		}
		if (flag == false) {
			responseData = new ResponseData();
			responseData.setCode(0);
			responseData.setMessage("填写信息有误！");
			return responseData;
		}
		//生成主键id
		responseData = new ResponseData();
		String idStr = emailinfo.getSenduser()+"love"+System.currentTimeMillis();
		//String codeid = StringUtil.encodeByMD5(emailinfo.getSenduser())+System.currentTimeMillis();
		emailinfo.setId(idStr);
		//emailinfo.setEventid(codeid);
		if (StringUtil.isEmpty(emailinfo.getEventid())) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			emailinfo.setEventid(simpleDateFormat.format(new Date()));
		}
		int add = emailInfoManager.add(emailinfo);
		//邮件通知发件人及收件人
		String emailsend = emailinfo.getSendemail();
		String emailrecive = emailinfo.getReciveemail();
		try {
			sendMailAcceUtils.sendMail(emailsend, "diy生成成功提醒！", "您好，定制服务已成功完成，查看生成结果身份码为:"+idStr+" ；点此链接：http://118.25.177.26:8022/diy/foru?view="+idStr+"；可直接点击查看", null, request);
			if(add>0) {
				responseData.setCode(1);
				responseData.setMessage("数据保存成功！");
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		try {
			sendMailAcceUtils.sendMail(emailrecive, "diy生成成功通知！", "您好，"+emailinfo.getSenduser()+"给您发送了查看邀请，查看生成结果身份码为:"+idStr+" ；点此链接：http://118.25.177.26:8022/diy/foru?view="+idStr+"；可直接点击查看", null, request);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return responseData;
	}
	
	
	/**
	 * 查看生成代码详情
	 * @param id
	 */
	public void viewCode(String id) { 
		
		
		
		
		
	}
	
	
	
	
	
	
}
