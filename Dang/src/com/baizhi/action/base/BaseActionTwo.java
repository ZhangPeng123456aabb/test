package com.baizhi.action.base;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��װ ������session��Ӧ����
 * 	ȡֵ   ��ֵ
 */
public class BaseActionTwo extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	/**
	 * ���л�Ψһ��ʶ
	 */
	private static final long serialVersionUID = -5010437055490413778L;
	/**
	 * �ദʹ��  �����Ա����
	 */
	private Map<String,Object> applicationMap;
	private Map<String,Object> sessionMap;
	private Map<String,Object> requestMap;
	@Override
	public void setApplication(Map<String, Object> applicationMap) {
		this.applicationMap = applicationMap;
	}
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
	/**
	 * ��ȡcookie
	 * @param requestMap
	 * @return 
	 */
	public Cookie[] getCookie(){
		return ServletActionContext.getRequest().getCookies();
	}
	/**
	 * ��Ӧ��������ֵ
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setApplicationAttribute(String ognl,Object val){
		applicationMap.put(ognl, val);
	}
	/**
	 * ��Ӧ������ȡֵ
	 * @param ognl
	 * @return
	 */
	public void getApplicationAttribute(String ognl){
		applicationMap.get(ognl);
	}
	/**
	 * ��Ӧ������ɾ��
	 * @param ognl
	 * @return
	 */
	public void removeApplicationAttribute(String ognl){
		applicationMap.remove(ognl);
	}
	/**
	 * ��session������ֵ
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setSessionAttribute(String ognl,Object val){
		sessionMap.put(ognl, val);
	}
	/**
	 * ��session����ȡֵ
	 * @param ognl
	 * @return
	 */
	public Object getSessionAttribute(String ognl){
		return sessionMap.get(ognl);
	}
	/**
	 * ��session����ɾ��
	 * @param ognl
	 * @return
	 */
	public void removeSessionAttribute(String ognl){
		sessionMap.remove(ognl);
	}
	/**
	 * ������������ֵ
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setRequestAttribute(String ognl,Object val){
		requestMap.put(ognl, val);
	}
	/**
	 * ����������ȡֵ
	 * @param ognl
	 * @return
	 */
	public Object getRequestAttribute(String ognl){
		return requestMap.get(ognl);
	}
	/**
	 * ����������ɾ��
	 * @param ognl
	 * @return
	 */
	public void removeRequestAttribute(String ognl){
		requestMap.remove(ognl);
	}
}
