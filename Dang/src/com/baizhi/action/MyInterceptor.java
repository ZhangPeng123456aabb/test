package com.baizhi.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		User user = (User)session.get("user");
		if(user != null){
			invoke.invoke();
		}else{
			response.sendRedirect("${pageContext.request.contextPath}/user/login_form.jsp");
		}
		return null;
	}
	
}
