package com.baizhi.pay_no_use;


import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

/**
 * 支付宝付款通知接口.
 * 
 * @version 1.0.0
 */
public final class NotifyUrlMgr {

	@SuppressWarnings("rawtypes")
	public static String insert(HttpServletRequest httpRequest) {
		// 定义变量和进行必要的初始化工作
		Enumeration parameterNames = null;
		String parameterName = null;
		String parameterValue = null;
		int count = 0;
		Vector[] params = null;
		Vector vParameterName = new Vector();
		Vector vParameterValue = new Vector();

		try {
			String orderId = httpRequest.getParameter("out_trade_no");// 订单号
			if (orderId == null || "".equals(orderId))
				orderId = "-1";
			parameterNames = httpRequest.getParameterNames();
			boolean isPrint = false;
			while (parameterNames.hasMoreElements()) {// 循环收取支付宝发来的所有参数信息
				parameterName = (String) parameterNames.nextElement();
				parameterValue = httpRequest.getParameter(parameterName);
				if (parameterValue == null)
					parameterValue = "";
				vParameterName.add(parameterName);
				vParameterValue.add(parameterValue);
				count++;
			}

			// 这里添加对收到信息的处理:一般是将这些信息存入数据库,然后对客户的订单进行处理.

			return null;
		} catch (Exception e) {
			return e.toString();
		} finally {
			//   
		}
	}

}

