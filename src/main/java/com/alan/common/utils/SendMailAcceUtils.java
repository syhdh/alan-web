package com.alan.common.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 发送邮件工具类
 * 
 * @author tp
 *
 */
@Component
public class SendMailAcceUtils {
	
	@Value("${mail.senduser}")
	private String from;
	
	@Value("${mail.access}")
	private String pass;
	
	@Value("${mail.host}")
	private String host;

    /**
     * 发送带附件的邮件
     * 
     * @param receive
     *            收件人
     * @param subject
     *            邮件主题
     * @param msg
     *            邮件内容
     * @param file
     *            附件
     * @return
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException 
     */
    public boolean sendMail(String receive, String subject, String msg, File file,HttpServletRequest request) throws GeneralSecurityException {
        if (StringUtils.isEmpty(receive)) {
            return false;
        }
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() { // qq邮箱服务器账户、第三方登录授权码
                return new PasswordAuthentication(from, pass); // 发件人邮件用户名、密码
            }
        });
        try {
        	// 设置属性
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            
            /*properties.put("userName","shaoyanghui_dh@163.com"); //这里填上你的邮箱（发送方）
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(properties.getProperty("userName")));*/
            
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive));
            // Set Subject: 主题文字
            message.setSubject(subject);
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText(msg);
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            // 附件部分
            messageBodyPart = new MimeBodyPart();
            // 设置要发送附件的文件路径
            File sendFile = file;
            //方法1：在指定目录，生成临时文件，然后再转换
            if (sendFile!=null) {
            	DataSource source = new FileDataSource(sendFile);
                messageBodyPart.setDataHandler(new DataHandler(source));
                // messageBodyPart.setFileName(filename);
                // 处理附件名称中文（附带文件路径）乱码问题
                try {
					messageBodyPart.setFileName(MimeUtility.encodeText(sendFile.getName()));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
                multipart.addBodyPart(messageBodyPart);
			}
            // 发送完整消息
            message.setContent(multipart);
            // 发送消息
            Transport.send(message);
            //发送成功后删除暂存的文件
            if (sendFile!=null) {
				sendFile.delete();
			}
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    
  
}