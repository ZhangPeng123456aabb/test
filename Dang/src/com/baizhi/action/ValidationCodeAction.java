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
		//调用工具方法获取验证码
		Captcha c = ValidationCodeUtils.getCaptcha();
		//获取内容
		String validationCode = c.getChallenge();
		//System.out.println("validationCode ="+validationCode);
		HttpSession session = req.getSession();
		session.setAttribute("validationCode", validationCode);
		//BuffedImage类型对象代表一个图片
		BufferedImage bi = c.getImage();
		
		//设置响应类型
		res.setContentType("image/png");
		res.setHeader("cache", "no-cache");
		//将图片通过输出流，响应回浏览器
		OutputStream out = res.getOutputStream();
		//将图片bi以png格式使用out流输出
		ImageIO.write(bi, "png", out);
		
	}
}
