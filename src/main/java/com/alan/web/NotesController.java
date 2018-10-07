package com.alan.web;

import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alan.common.utils.SendMailAcceUtils;

@Controller
@RequestMapping("/model")
public class NotesController {
	
	/**
	 * 邮件
	 */
	@Autowired
	private SendMailAcceUtils sendMailAcceUtils;
	
	
	/**
	 * 查看简历模板
	 * @param note
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toNote(String note,HttpServletRequest request) {
		//TODO 发邮件通知自己
		try {
			sendMailAcceUtils.sendMail("shaoyanghui_dh@163.com", "来客访问提醒！", "ip地址为："+getIpAdrress(request), null, request);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("/notes/model");
		return modelAndView;
	}
	
	
	/**
     * 获取Ip地址
     * @param request
     * @return
     */
    private static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return "真实ip:"+XFor.substring(0,index)+"；代理ip："+XFor;
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }


	

}
