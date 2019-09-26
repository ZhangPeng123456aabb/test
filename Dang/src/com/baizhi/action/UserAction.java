package com.baizhi.action;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MD5Util;
import com.baizhi.util.MailUtil;

public class UserAction {
HttpServletRequest request = ServletActionContext.getRequest();
HttpSession session = request.getSession();
HttpServletResponse response  = ServletActionContext.getResponse();
UserService us = new UserServiceImpl();
private User u;
private Integer code;
private Integer i;

public Integer getI() {
	return i;
}
public void setI(Integer i) {
	this.i = i;
}
public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
public String login(){
	String validationCode = request.getParameter("validateCode");
	User u1 = new User();
	u1 = us.login(u);
	u1.setState(0);
	String validationCode1=(String)session.getAttribute("validationCode");
	if(u1!=null && validationCode1.equalsIgnoreCase(validationCode)){
		session.setAttribute("user", u1);
		us.updateState(u1);
		return "loginSuccess";
	}else{
		return "loginFail";
	}
}
public String register() throws NoSuchAlgorithmException{
	String validationCode = request.getParameter("validateCode");
	User u1 = new User();
	u1=us.login(u);
	System.out.println(u1);
	String validationCode1=(String)session.getAttribute("validationCode");
	if(u1==null && validationCode1.equalsIgnoreCase(validationCode)){
		u.setPassword(MD5Util.encrypt(u.getPassword()));
		us.register(u);
		User user = u;
		session.setAttribute("user", user);
		i=MailUtil.sendSimpleMail(u.getEmail());
		return "registerSuccess";
	}else{
		return "registerFail";
	}
}
public String Exit(){
	User u2 = new User();
	u2 =(User)session.getAttribute("user");
	us.updateState(u2);
    return "ExitSuccess";
	}
public String verify(){
	if(code==123456 && i==1){
		return "vectory";
	}else{
		return "NoVectory";
	}
}
}
