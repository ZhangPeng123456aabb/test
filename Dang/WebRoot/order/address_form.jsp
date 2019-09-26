<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<link href="../css/address.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	$("[name='addressId']").click(function(){
		//当前被点击的行的兄弟元素样式被移除
		$("[name='a']").prop("class","address-wrap");
		$(".marker-tip").html("");
		
		$(this).parent().parent().prop("class","address-wrap selected");
		$(this).prop("checked","checked");
		$(this).parent().prev().children().html("寄送至");
	});
});
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤:<span class="red_bold">1.填写送货地址</span>> 2.确认订单 > 3.订单成功<span style="float:right"> <a href="${pageContext.request.contextPath}/address/a_selectAllAddress">地址管理<a/></span>
	</div>
	<div class="fill_message">
		 <form action="${pageContext.request.contextPath}/order/o_insertOrder" method="post">
			 <div class="address-wrap">
				<ul class="address-list">
				<s:iterator value="add">
					<s:if test="status == 1">
							<li class="address-wrap selected" name="a" >
								<div class="addressBox">
									<span class="marker-tip">寄送至</span>
								</div>
								<label class="addressInfo">
									<input checked="checked" type="radio" name="addressId" value="<s:property value="id"/>"/>
									</s:if>
									<s:else>
										<li name="a" class="address-wrap">
								<div class="addressBox">
									<span class="marker-tip"></span>
								</div>
								<label class="addressInfo">
									<input type="radio" name="addressId" value="<s:property value="id"/>"/>
									</s:else>
									<span class="user-address">
										<span><s:property value="address"/></span>
										<span>（</span>
										<span><s:property value="receive_name"/></span>
										<span> 收）</span>
										<em><s:property value="telphone"/></em>
									</span>
								</label>
							</li>	
			        </s:iterator>
				</ul>
			</div>
			<div class="login_in">
				<input
					id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="下一步" />
			</div>
			
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

