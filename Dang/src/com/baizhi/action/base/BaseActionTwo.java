package com.baizhi.action.base;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 封装 请求域、session域、应用域
 * 	取值   塞值
 */
public class BaseActionTwo extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	/**
	 * 序列化唯一标识
	 */
	private static final long serialVersionUID = -5010437055490413778L;
	/**
	 * 多处使用  定义成员变量
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
	 * 获取cookie
	 * @param requestMap
	 * @return 
	 */
	public Cookie[] getCookie(){
		return ServletActionContext.getRequest().getCookies();
	}
	/**
	 * 向应用域里塞值
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setApplicationAttribute(String ognl,Object val){
		applicationMap.put(ognl, val);
	}
	/**
	 * 从应用域里取值
	 * @param ognl
	 * @return
	 */
	public void getApplicationAttribute(String ognl){
		applicationMap.get(ognl);
	}
	/**
	 * 从应用域里删除
	 * @param ognl
	 * @return
	 */
	public void removeApplicationAttribute(String ognl){
		applicationMap.remove(ognl);
	}
	/**
	 * 向session域里塞值
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setSessionAttribute(String ognl,Object val){
		sessionMap.put(ognl, val);
	}
	/**
	 * 从session域里取值
	 * @param ognl
	 * @return
	 */
	public Object getSessionAttribute(String ognl){
		return sessionMap.get(ognl);
	}
	/**
	 * 从session域里删除
	 * @param ognl
	 * @return
	 */
	public void removeSessionAttribute(String ognl){
		sessionMap.remove(ognl);
	}
	/**
	 * 向请求域里塞值
	 * @param ognl
	 * @param val
	 * @return
	 */
	public void setRequestAttribute(String ognl,Object val){
		requestMap.put(ognl, val);
	}
	/**
	 * 从请求域里取值
	 * @param ognl
	 * @return
	 */
	public Object getRequestAttribute(String ognl){
		return requestMap.get(ognl);
	}
	/**
	 * 从请求域里删除
	 * @param ognl
	 * @return
	 */
	public void removeRequestAttribute(String ognl){
		requestMap.remove(ognl);
	}
}
