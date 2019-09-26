<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baizhi.pay_no_use.NotifyUrlMgr"%>
<%   
    String ret = NotifyUrlMgr.insert(request);   
    if(ret==null){   
        out.print("success");//成功接收支付宝发来的付款信息   
    }else{   
        out.print("fail");//出错   
    }   
%>  
