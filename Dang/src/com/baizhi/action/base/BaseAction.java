package com.baizhi.action.base;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * ��װ������ session application
 * 	
 * application��sessionһ��  ���ﲻ�ٶ�д
 */
public class BaseAction extends ActionSupport{
	/**
	 * ���л�Ψһ��ʶ
	 */
	private static final long serialVersionUID = 6062494302671465223L;
	
	private static ValueStack vs;
	/**
	 * ������ʱ�����ȵ����޲ι��캯��
	 */
	public BaseAction(){
		super();
		ActionContext ac = ServletActionContext.getContext();
		vs  = ac.getValueStack();
	}
	/**
	 * ��ȡvsֵջ����session������������ֵ
	 * @param ognl
	 * @param val
	 */
	public void setSessionAttribute(String ognl,String val){
		vs.setValue("#session."+ognl, val);
	}
	/**
	 * ��ȡֵջ�󣬴�session��������ȡֵ
	 * @param ognl
	 * @return
	 */
	public Object getSessionAttribute(String ognl){
		return vs.findValue("#session."+ognl);
	}
}
