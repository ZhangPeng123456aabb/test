package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.service.Captcha;

import com.baizhi.util.ValidationCodeUtils;

@WebServlet("/validationCode.png")
public class ValidationCodeAction extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//���ù��߷�����ȡ��֤��
		Captcha c = ValidationCodeUtils.getCaptcha();
		//��ȡ����
		String validationCode = c.getChallenge();
		//System.out.println("validationCode ="+validationCode);
		HttpSession session = req.getSession();
		session.setAttribute("validationCode", validationCode);
		//BuffedImage���Ͷ������һ��ͼƬ
		BufferedImage bi = c.getImage();
		
		//������Ӧ����
		res.setContentType("image/png");
		res.setHeader("cache", "no-cache");
		//��ͼƬͨ�����������Ӧ�������
		OutputStream out = res.getOutputStream();
		//��ͼƬbi��png��ʽʹ��out�����
		ImageIO.write(bi, "png", out);
		
	}
}
