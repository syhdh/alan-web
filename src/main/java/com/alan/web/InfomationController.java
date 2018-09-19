package com.alan.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alan.common.utils.SendMailAcceUtils;
import com.alan.common.utils.StringUtil;
import com.alan.model.FileInfoModel;
import com.alan.model.User;
import com.alan.oss.file.AliyunOSSClientUtil;
import com.aliyun.oss.OSSClient;

/**
 * 站内通信
 * @author shaoy
 *
 */
@Controller
@RequestMapping("/info")
public class InfomationController {
	
	private String bucketName = "np-alan";
	
	@Autowired
	private AliyunOSSClientUtil aliyunOSSClientUtil;
	
	// 阿里云API的内或外网域名
    @Value("${np.oss.endpoint}")
    private static String ENDPOINT;
	
	/**
	 * 邮件
	 */
	@Autowired
	private SendMailAcceUtils sendMailAcceUtils;
	
	
	
	/**
	 * 短信
	 */
	
	
	
	/**
	 * 通知
	 */
	@RequestMapping("/email")
	public ModelAndView toNews(String mail){
		ModelAndView modelAndView = new ModelAndView("/email/mailcompose");
		modelAndView.addObject("mail", mail);
		return modelAndView;
	}
	
	@RequestMapping("/fileupload")
	@ResponseBody
	public String uploadFile(MultipartFile file,HttpServletRequest request) {
		//this.file = file;
		//在根目录下创建一个tempfileDir的临时文件夹
        String contextpath = System.getProperty("user.dir")+"\\tempfileDir";
        File f = new File(contextpath); 
        if(!f.exists()){
            f.mkdirs();
        }
        //在tempfileDir的临时文件夹下创建一个新的和上传文件名一样的文件
        String filename = file.getOriginalFilename();
        String filepath = contextpath+"\\"+filename;
        try {
        	BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
        	byte[] bytes = file.getBytes();
            buffStream.write(bytes);
            buffStream.close();
            request.getSession().setAttribute("filepath", filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	@RequestMapping("/sendEmail")
	@ResponseBody
	public boolean sendMailInfo(String receive,String subject,String msg,HttpServletRequest request) {
		String filepath = (String) request.getSession().getAttribute("filepath");
		File file = null;
		if (StringUtil.isNotEmpty(filepath)) {
			file = new File(filepath);
		}
		boolean flag = false;
		try {
			flag = sendMailAcceUtils.sendMail(receive, subject, msg, file, request);
		} catch (GeneralSecurityException e) {
			//邮件发送失败
			e.printStackTrace();
		}
		request.getSession().removeAttribute("filepath");
		return flag;
	}
	
	
	/**
	 * 多文件上传
	 */
	@RequestMapping("/imgupload")
	public ModelAndView imgUpload() {
		ModelAndView modelAndView = new ModelAndView("upload/pcimg/imgarr");
		return modelAndView;
	}
	
	@RequestMapping("/imgarr")
	@ResponseBody
	public String imgArrupload(@RequestParam("fileList")MultipartFile fileList,HttpServletRequest request) {
		//获取登录用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		OSSClient ossClient = null;
		try {
			ossClient = aliyunOSSClientUtil.getOSSClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileInfoModel fileInfo = aliyunOSSClientUtil.uploadObject2OSS(ossClient,fileList, bucketName, user);
		return fileInfo.getImgUrl().substring(0, fileInfo.getImgUrl().indexOf("?"));
	}

}
