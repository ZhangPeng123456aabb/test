package com.baizhi.action.base;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 封装作用域 session application
 * 	
 * application和session一样  这里不再多写
 */
public class BaseAction extends ActionSupport{
	/**
	 * 序列化唯一标识
	 */
	private static final long serialVersionUID = 6062494302671465223L;
	
	private static ValueStack vs;
	/**
	 * 构建类时，首先调用无参构造函数
	 */
	public BaseAction(){
		super();
		ActionContext ac = ServletActionContext.getContext();
		vs  = ac.getValueStack();
	}
	/**
	 * 获取vs值栈后，向session作用域里设置值
	 * @param ognl
	 * @param val
	 */
	public void setSessionAttribute(String ognl,String val){
		vs.setValue("#session."+ognl, val);
	}
	/**
	 * 获取值栈后，从session作用域里取值
	 * @param ognl
	 * @return
	 */
	public Object getSessionAttribute(String ognl){
		return vs.findValue("#session."+ognl);
	}
}
