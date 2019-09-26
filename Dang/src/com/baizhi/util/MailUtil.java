package com.baizhi.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 1.设置发送邮件的一些参数
	private static Properties pro = new Properties();

	static {
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.host", "smtp.qq.com");
		pro.setProperty("mail.smtp.auth", "true");
		pro.setProperty("mail.smtp.port", "587");
	}

	public static int sendSimpleMail(String recipients) {
		int res = 0;
		try {
			// 2.创建一个会话对象和邮件服务器交互
			Session session = Session.getDefaultInstance(pro);
			// 3.创建一个邮件对象
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("1291758809@qq.com")); // 发送人

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(recipients)); // 收件人

			message.setSubject("你的当当网邮件验证码");// 设置邮件的标题

			message.setContent("123456", "text/html;charset=UTF-8");// 设置邮件的正文

			message.setSentDate(new Date());// 发送时间

			message.saveChanges(); // 保存设置

			Transport transport = session.getTransport();// 获取一个传输对象

			transport.connect("1291758809@qq.com", "yzimgprrregijibg");// 设置发送邮件用户名和密码

			transport.sendMessage(message, message.getAllRecipients());// 发送邮件

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
