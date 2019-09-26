package com.baizhi.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 1.���÷����ʼ���һЩ����
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
			// 2.����һ���Ự������ʼ�����������
			Session session = Session.getDefaultInstance(pro);
			// 3.����һ���ʼ�����
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("1291758809@qq.com")); // ������

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(recipients)); // �ռ���

			message.setSubject("��ĵ������ʼ���֤��");// �����ʼ��ı���

			message.setContent("123456", "text/html;charset=UTF-8");// �����ʼ�������

			message.setSentDate(new Date());// ����ʱ��

			message.saveChanges(); // ��������

			Transport transport = session.getTransport();// ��ȡһ���������

			transport.connect("1291758809@qq.com", "yzimgprrregijibg");// ���÷����ʼ��û���������

			transport.sendMessage(message, message.getAllRecipients());// �����ʼ�

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
