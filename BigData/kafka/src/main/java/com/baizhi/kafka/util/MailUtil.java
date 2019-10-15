package com.baizhi.kafka.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
           // 发送人
            message.setFrom(new InternetAddress("2281306880@qq.com"));

            message.setRecipient(MimeMessage.RecipientType.TO,
                    // 收件人
                    new InternetAddress(recipients));
            // 设置邮件的标题
            message.setSubject("验证码");
            // 设置邮件的正文
            message.setContent(code.getCode(), "text/html;charset=UTF-8");
            // 发送时间
            message.setSentDate(new Date());

            message.saveChanges(); // 保存设置
            // 获取一个传输对象
            Transport transport = session.getTransport();
            // 设置发送邮件用户名和密码
            transport.connect("2281306880@qq.com", "kjokckfnkvdodjif");
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());

            transport.close();
            res = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
