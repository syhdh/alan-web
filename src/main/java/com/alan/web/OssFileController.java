package com.alan.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alan.common.utils.ResponseCode;
import com.alan.common.utils.ResponseData;
import com.alan.model.FileInfoModel;
import com.alan.model.User;
import com.alan.oss.file.AliyunOSSClientUtil;
import com.aliyun.oss.OSSClient;

@RestController
@RequestMapping("/file")
public class OssFileController {
	
	
	private String bucketName = "np-alan";
	
	@Autowired
	private AliyunOSSClientUtil aliyunOSSClientUtil;
	
	// 阿里云API的内或外网域名
    @Value("${np.oss.endpoint}")
    private static String ENDPOINT;
	
	/**
	 * 文件上传
	 * @param file File 文件
	 * @param bucketName ossbucket名称
	 * @param request
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public FileInfoModel fileUpload(@RequestPart("file") MultipartFile file,HttpServletRequest request){
		//获取登录用户
		User user = (User) request.getSession().getAttribute("user");
		OSSClient ossClient = null;
		try {
			ossClient = aliyunOSSClientUtil.getOSSClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileInfoModel fileInfo = aliyunOSSClientUtil.uploadObject2OSS(ossClient,file, bucketName, user);
		return fileInfo;
	}
	
	/**
	 * 查看文件
	 * 私有权限的bucket暂不支持缩放
	 * @param bucketName ossbucket名称
	 * @param fileName 文件名
	 * @return
	 */
	@PostMapping("/private/imgUrl")
	@ResponseBody
	public ResponseData generatorPrivateImgUrl(String bucketName,String fileName){
		ResponseData responseData = null;
		OSSClient ossClient = aliyunOSSClientUtil.getOSSClient();
		if (fileName.contains(".")) {
			int lastIndexOf = fileName.lastIndexOf(".");
			String folder = fileName.substring(lastIndexOf+1)+"/"+fileName;
			responseData = new ResponseData(ResponseCode.SUCCESS);
			String url = aliyunOSSClientUtil.getUrl(ossClient, bucketName, folder);
			responseData.setData(url);
		}else {
			responseData = new ResponseData(ResponseCode.ERROR);
			responseData.setMessage("文件格式错误！");
		}
		return responseData;
	}
	
	/**
	 * 访问公有文件链接
	 * @param bucketName ossbucket名称
	 * @param fileName 文件名
	 * @param percent 缩放百分比（int），默认原图
	 * @return
	 */
	@PostMapping("/public/imgUrl")
	@ResponseBody
	public ResponseData generatorImgUrl(String fileName,Integer percent){
		ResponseData responseData = null;
		OSSClient ossClient = aliyunOSSClientUtil.getOSSClient();
		if (fileName.contains(".")) {
			int lastIndexOf = fileName.lastIndexOf(".");
			String folder = fileName.substring(lastIndexOf+1)+"/"+fileName;
			responseData = new ResponseData(ResponseCode.SUCCESS);
			String url = aliyunOSSClientUtil.getUrl(ossClient, bucketName, folder);
			int indexOf = url.indexOf("?");
			if (percent!=null&&percent!=0&&url.contains("Expires=")&&url.contains("Signature=")) {
				url = url.substring(0, indexOf)+"?x-oss-process=image/resize,p_" + percent;
			}
			responseData.setData(url);
		}else {
			responseData = new ResponseData(ResponseCode.ERROR);
			responseData.setMessage("文件格式错误！");
		}
		return responseData;
	}
	
	/**
	 * 文件下载
	 * @param request 请求
	 * @param response 响应
	 * @param bucketName bucket名称
	 * @param fileName 文件名
	 */
	@RequestMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response,String fileName){
		aliyunOSSClientUtil.downLoadFile(request, response, bucketName, fileName);
	}
	
}
