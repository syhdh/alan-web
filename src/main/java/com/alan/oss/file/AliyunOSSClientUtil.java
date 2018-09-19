package com.alan.oss.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.alan.common.utils.CommonUtils;
import com.alan.common.utils.ResponseCode;
import com.alan.common.utils.ResponseData;
import com.alan.model.FileInfoModel;
import com.alan.model.User;
import com.alan.service.OssFileManager;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;


/**
 * @author shaoy 阿里云oss文件系统上传模块
 */
@Component
public class AliyunOSSClientUtil {

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private OssFileManager ossFileManager;

	// log日志
	private static Logger logger = Logger.getLogger(AliyunOSSClientUtil.class);
	// 阿里云API的内或外网域名
	@Value("${np.oss.endpoint}")
	private String ENDPOINT;
	// 阿里云API的密钥Access Key ID
	@Value("${np.oss.accessKeyId}")
	private String ACCESS_KEY_ID;
	// 阿里云API的密钥Access Key Secret
	@Value("${np.oss.accessKeySecret}")
	private String ACCESS_KEY_SECRET;

	/**
	 * 获取阿里云OSS客户端对象
	 * @return ossClient
	 */
	public OSSClient getOSSClient() {
		return new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
	}

	/**
	 * 创建存储空间
	 * @param ossClient OSS连接
	 * @param bucketName  存储空间
	 * @return
	 */
	public String createBucketName(OSSClient ossClient, String bucketName) {
		// 存储空间
		final String bucketNames = bucketName;
		if (!ossClient.doesBucketExist(bucketName)) {
			// 创建存储空间
			Bucket bucket = ossClient.createBucket(bucketName);
			logger.info("创建存储空间成功");
			return bucket.getName();
		}
		return bucketNames;
	}

	/**
	 * 删除存储空间buckName
	 * @param ossClient  oss对象
	 * @param bucketName  存储空间
	 */
	public void deleteBucket(OSSClient ossClient, String bucketName) {
		ossClient.deleteBucket(bucketName);
		logger.warn("删除" + bucketName + "Bucket成功");
	}

	/**
	 * 创建模拟文件夹
	 * @param ossClient oss连接
	 * @param bucketName  存储空间
	 * @param folder    模拟文件夹名如"qj_nanjing/"
	 * @return 文件夹名
	 */
	public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
		// 文件夹名
		final String keySuffixWithSlash = folder;
		// 判断文件夹是否存在，不存在则创建
		if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
			// 创建文件夹
			ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
			logger.info("创建文件夹成功");
			// 得到文件夹名
			OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
			String fileDir = object.getKey();
			return fileDir;
		}
		return keySuffixWithSlash;
	}

	/**
	 * 根据key删除OSS服务器上的文件
	 * @param ossClient  oss连接
	 * @param bucketName 存储空间
	 * @param folder 模拟文件夹名 如"qj_nanjing/"
	 * @param key  Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
	 */
	public void deleteFile(OSSClient ossClient, String bucketName, String key) {
		ossClient.deleteObject(bucketName, key);
		logger.info("删除" + bucketName + "下的文件" + key + "成功");
	}

	/**
	 * 上传图片至OSS 文件流
	 * @param ossClient   oss连接
	 * @param file
	 * @param bucketName  存储空间
	 * @param folder 模拟文件夹名 如"qj_nanjing/"
	 * @return String 返回的唯一MD5数字签名
	 */
	public ResponseData uploadObject2OSS(OSSClient ossClient, File file, String bucketName, User user) {
		ResponseData responseData = null;
		long timestamp = System.currentTimeMillis();
		String encodeByMD5 = commonUtils.encodeByMD5(bucketName + Math.random() + timestamp);
		FileInfoModel fileInfo = new FileInfoModel();
		String resultStr = null;
		fileInfo.setId(encodeByMD5.toLowerCase());
		fileInfo.setFileSize(file.length());
		fileInfo.setCreattionDate(timestamp);
		fileInfo.setCreateUserId(user.getUserid());
		fileInfo.setCreateUserName(user.getNickname());
		String[] fo = new String[] { "", "" };
		// 以输入流的形式上传文件
		InputStream is = null;
		// 文件名
		String fileName = file.getName();
		if ((fileName.lastIndexOf(".") + 1) == fileName.length()) {
			responseData = new ResponseData(ResponseCode.ERROR);
			responseData.setMessage("文件格式不支持，请检查 ！");
		}
		try {
			is = new FileInputStream(file);
		} catch (IOException e1) {
			logger.warn("文件流读取异常！" + e1.getMessage());
			responseData = new ResponseData(ResponseCode.ERROR);
			responseData.setMessage("文件流读取异常！");
		}
		fileInfo.setMimeType(fileName.substring(fileName.lastIndexOf(".") + 1));
		// 上传目录
		String folder = fileName.substring(fileName.indexOf(".")+1);
		fileName = encodeByMD5.toLowerCase() + fileName.substring(fileName.lastIndexOf("."));
		fileInfo.setOsskey(fileName);
		fileInfo.setOssBucket(bucketName);
		logger.info("上传到路径" +folder+"/"+ fileName);
		try {
			// 文件大小
			Long fileSize = file.length();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(is.available());
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");
			// 如果没有扩展名则填默认值application/octet-stream
			metadata.setContentType(getContentType(fileName));
			// 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
			metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
			// 上传文件 (上传文件流的形式)
			fileName = fileName.substring(fileName.lastIndexOf(".")+1)+"/"+fileName;
			PutObjectResult putResult = ossClient.putObject(bucketName, fileName, is, metadata);
			// 解析结果
			resultStr = putResult.getETag();
			fo[1] = fileName;
			fo[0] = resultStr;
			String url = getUrl(ossClient, bucketName, fo[1]);
			fileInfo.setImgUrl(url);
			ossClient.shutdown();
			logger.info("文件上传成功，保存文件信息为：" + fileInfo.toString());
			responseData = new ResponseData(ResponseCode.SUCCESS);
			responseData.setData(fileInfo);
		} catch (Exception e) {
			e.printStackTrace();
			deleteFile(ossClient, bucketName, fileName);
			logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
			logger.warn("发生错误，已删除" + bucketName + "下的文件" + fileName);
			responseData = new ResponseData(ResponseCode.ERROR);
		}
		return responseData;
	}

	/**
	 * 获得url链接,2小时有效期
	 * @param key
	 * @return
	 */
	public String getUrl(OSSClient ossClient, String bucketName, String fileName) {
		// 设置URL过期时间为10年 3600l* 1000*24*365*10
		Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 2);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
		if (url != null) {
			return url.toString();
		}
		return "获文件路径出错";
	}


	/**
	 * 上传图片至OSS 文件流 表单提交方式上传
	 * 
	 * @param ossClient  oss连接
	 * @param MultipartFile 上传文件
	 * @param bucketName   存储空间
	 * @param folder  文件夹名 如"qj_nanjing/"
	 * @return String 返回的唯一MD5数字签名
	 * @throws IOException
	 */
	public FileInfoModel uploadObject2OSS(OSSClient ossClient, MultipartFile file, String bucketName, User user) {
		long timestamp = System.currentTimeMillis();
		String encodeByMD5 = commonUtils.encodeByMD5(bucketName + Math.random() + timestamp);
		FileInfoModel fileInfo = new FileInfoModel();
		String resultStr = null;
		fileInfo.setId(encodeByMD5.toLowerCase());
		fileInfo.setFileSize(file.getSize());
		fileInfo.setCreattionDate(timestamp);
		fileInfo.setCreateUserId(user.getUserid());
		fileInfo.setCreateUserName(user.getNickname());
		String[] fo = new String[] { "", "" };
		// 以输入流的形式上传文件
		//String folder = "";
		InputStream is = null;
		// 文件名
		String fileName = file.getOriginalFilename();
		String folder = fileName.substring(fileName.indexOf(".")+1);
		try {
			is = file.getInputStream();
		} catch (IOException e1) {
			logger.warn("文件流读取异常！" + e1.getMessage());
			//throw new CustomException("文件上传出现异常！", HttpStatus.BAD_REQUEST);
		}
		//fileInfo.setMimeType(MimeUtil.getMimeTypes(file.getInputStream()).toString());
		fileInfo.setMimeType(file.getContentType());
		// 上传目录
		//folder = fileName.substring(fileName.lastIndexOf(".") + 1) + "/";
		fileName = encodeByMD5.toLowerCase() + fileName.substring(fileName.lastIndexOf("."));
		fileInfo.setOsskey(fileName);
		fileInfo.setOssBucket(bucketName);
		logger.info("上传到路径:/" + folder+"/"+ fileName);
		try {
			// 文件大小
			Long fileSize = file.getSize();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(is.available());
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");
			// 如果没有扩展名则填默认值application/octet-stream
			metadata.setContentType(getContentType(fileName));
			// 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
			fileName = fileName.substring(fileName.lastIndexOf(".")+1)+"/"+fileName;
			metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
			// 上传文件 (上传文件流的形式)
			PutObjectResult putResult = ossClient.putObject(bucketName,fileName, is, metadata);
			// 解析结果
			resultStr = putResult.getETag();
			fo[1] = fileName;
			fo[0] = resultStr;
			String url = getUrl(ossClient, bucketName, fo[1]);
			//fileInfo.setImgUrl(url.substring(0, url.indexOf("?")));
			fileInfo.setImgUrl(url);
			ossClient.shutdown();
			int addFileInfo = ossFileManager.addFileInfo(fileInfo);
			if (addFileInfo>0) {
				logger.info("保存正常！");
			}
			//fileManager.addFile(fileInfo);
			logger.info("文件上传成功，保存文件信息为：" + fileInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			deleteFile(ossClient, bucketName, fileName);
			logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
			logger.warn("发生错误，已删除" + bucketName+"/"+ folder+"/" + "下的文件:" + fileName);
			//throw new CustomException("文件上传出现异常！", HttpStatus.BAD_REQUEST);
		}
		return fileInfo;
	}

	/**
	 * 从阿里云下载文件 （以附件形式下载）
	 * 
	 * @param request
	 * @param response
	 */
	public void downLoadFile(HttpServletRequest request, HttpServletResponse response, String bucketName,
			String fileName) {
		try {
			String fileid = fileName.substring(fileName.indexOf(".")+1)+"/"+fileName;// CommonUtils.getOssSrcByFileName(fileName);// 从前台获取当前下载文件的id值（每个上传到阿里云的文件都会有一个独一无二的id值）
			// String filename
			// =request.getParameter("filename").toString();//从前台获取要下载文件的文件名
			// int i=filename.lastIndexOf("\\");
			// filename=filename.substring(i+1);
			OSSClient ossClient = getOSSClient();
			// 获取fileid对应的阿里云上的文件对象
			OSSObject ossObject = null;
			try {
				ossObject = ossClient.getObject(bucketName, fileid);
			} catch (Exception e) {
				// 文件不存在异常
				//throw new CustomException(fileName + "在oss系统" + bucketName + "中不存在", HttpStatus.BAD_REQUEST);
			}
			// 读去Object内容 返回
			BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
			// System.out.println(ossObject.getObjectContent().toString());
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			// 通知浏览器以附件形式下载
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
			byte[] car = new byte[1024];
			int L = 0;
			while ((L = in.read(car)) != -1) {
				out.write(car, 0, L);
			}
			if (out != null) {
				out.flush();
				out.close();
			}
			if (in != null) {
				in.close();
			}
			ossClient.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 上传本地文件
	/**
	 * 测试用例
	 * 
	 * @param url
	 * @param user_id
	 * @param bucketName
	 * @return
	 */
	/*public String uploadvideo(String url, String user_id, String bucketName) {
		String[] urllist = uploadObject2OSS(getOSSClient(), new File(url), bucketName);
		String c = urllist[1];
		return c;
	}*/

	/**
	 * 通过文件名判断并获取OSS服务文件上传时文件的contentType
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件的contentType
	 */
	public String getContentType(String fileName) {
		// 文件的后缀名
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));
		if (".bmp".equalsIgnoreCase(fileExtension)) {
			return "image/bmp";
		}
		if (".gif".equalsIgnoreCase(fileExtension)) {
			return "image/gif";
		}
		if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
				|| ".png".equalsIgnoreCase(fileExtension)) {
			return "image/jpeg";
		}
		if (".html".equalsIgnoreCase(fileExtension)) {
			return "text/html";
		}
		if (".txt".equalsIgnoreCase(fileExtension)) {
			return "text/plain";
		}
		if (".vsd".equalsIgnoreCase(fileExtension)) {
			return "application/vnd.visio";
		}
		if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
			return "application/vnd.ms-powerpoint";
		}
		if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)
				|| ".cad".equalsIgnoreCase(fileExtension)) {
			return "application/msword";
		}
		if (".xml".equalsIgnoreCase(fileExtension)) {
			return "text/xml";
		}
		if (".mp4".equalsIgnoreCase(fileExtension)) {
			return "video/mp4";
		}
		// 默认返回类型
		return "application/octet-stream";
	}
}
