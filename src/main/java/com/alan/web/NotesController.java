package com.alan.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alan.common.utils.AddressUtils;
import com.alan.common.utils.SendMailAcceUtils;
import com.alan.threads.SendInfoForAdmin;

@Controller
@RequestMapping("/model")
public class NotesController {
	
	/**
	 * 邮件
	 */
	@Autowired
	private SendMailAcceUtils sendMailAcceUtils;
	
	@Autowired
	private AddressUtils addressUtils;
	
	
	/**
	 * 查看简历模板
	 * @param note
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toNote(String note,HttpServletRequest request) {
		//TODO 发邮件通知自己
		SendInfoForAdmin sendInfoForAdmin = new SendInfoForAdmin("shaoyanghui_dh@163.com", "简历访问提醒！", "访客ip地址为："+getIpAdrress(request)+"", null, sendMailAcceUtils, request);
		sendInfoForAdmin.run();
		ModelAndView modelAndView = new ModelAndView("/notes/model");
		return modelAndView;
	}
	
	
	/**
     * 获取Ip地址
     * @param request
     * @return
     */
    private  String getIpAdrress(HttpServletRequest request) {
    	String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
    			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
    			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
    			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    			
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
            	if (XFor.matches(regex)) {
                	return addressUtils.getAddress(XFor.substring(0,index))+"；代理ip："+XFor;
        		}
                return "真实ip:"+XFor.substring(0,index)+"；代理ip："+XFor;
            }else{
            	if (XFor.matches(regex)) {
                	return addressUtils.getAddress(XFor);
        		}
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
        	if (XFor.matches(regex)) {
            	return addressUtils.getAddress(XFor);
    		}
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
        if (XFor.matches(regex)) {
        	return addressUtils.getAddress(XFor);
		}
        return XFor;
    }


	

}
