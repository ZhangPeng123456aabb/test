<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>收获地址管理 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
        <script type="text/javascript">
        /* 	$(function(){
        		var i =0;
        		$("a#aa").click(function(){
        			if(i==0){
	        			$(this).children().html("默认收货地址");
	        			i++;
        			}else if(i==1){
	        			$(this).children().html("设置为默认");
	        			i--;
        			}
        		});
        	}); */
        </script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			我的收货地址：
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址编号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人姓名</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人地址</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人联系方式</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址状态</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>操作</b>
					</td>
				</tr>
				<s:iterator value="add" status="s">
				<!-- 收货地址开始 -->
				<tr>
					<td valign="top">
					<s:property value="#s.count"/>
					</td>
					<td valign="top">
						<s:property value="id"/>
					</td>
					<td valign="top">
						  <s:property value="receive_name"/>
					</td>
					<td valign="top">
						   <s:property value="address"/>
					</td>
					<td valign="top">
						  <s:property value="telphone"/>
					</td>
					<td valign="top">
						   <a href="${pageContext.request.contextPath}/address/a_updateAddress?id=<s:property value="id"/>&ddr.UserId=<s:property value="UserId"/>" id="aa">
						   			<s:if test="status==0">
						                <sapn>设置为默认</sapn>
						            </s:if>
						            <s:else>
						            	<sapn>默认收货地址</sapn>
						            </s:else>
						    </a>
					</td>
					<td valign="top">
						  <a  href="${pageContext.request.contextPath}/address/a_deleteAddress?id=<s:property value="id"/>">删除</a>
					</td>
				</tr>
				</s:iterator>
				<!--收货地址结束 -->
			</table>
			
			<div style="margin: 50px;text-align: center;">
				<a href="../address/add_address.jsp">添加新的收货地址</a>
				<a href="../main/main.jsp">
					<input 	class="button_1"  type="button" value="取消" />
				</a>  
	    	</div>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html> 
