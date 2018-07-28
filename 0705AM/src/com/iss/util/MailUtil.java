package com.iss.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static String myEmailAccount="lj_cauc@163.com";
	public static String myEmailPassword="jjlan2016";
	public static String myEmailSMTPHost="smtp.163.com";
	public static String receiveMailAccount="1157768533@qq.com";
	public static String smtpPort="465";
	
	public static void sendMail() {
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", myEmailSMTPHost);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.port", smtpPort);
			
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", smtpPort);
			
			Session session = Session.getDefaultInstance(props);
			session.setDebug(true);
			
			//发件人
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(myEmailAccount,"智障媛","utf-8"));
			
			
			//收件人
			msg.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(receiveMailAccount,"xxx","utf-8"));
			//邮件的主题
			msg.setSubject("拔粪宝","UTF-8");
			
			//邮件的正文部分
			msg.setContent("邮件测试","text/html; charset=UTF-8");
			
			
			//设定发件时间
			msg.setSentDate(new Date());
			
			//保存邮件的设置
			msg.saveChanges();
			
			
			/***************发送类消息******************/
			Transport transport = session.getTransport();
			//连接发件服务器
			transport.connect(myEmailAccount,myEmailPassword);
			
			
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
