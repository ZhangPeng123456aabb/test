<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单</title>
		<link rel="stylesheet"href="../css/dingdan.css"type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#zhifu").click(function(){
					console.log(1);
					var bookname=$(".sp").html();
					var TotalPrice=$("#totalPrice").html();
					var Descr=$("#descr").html();
					var OrderId = $("#OrderId").html();
					$(this).prop("href","${pageContext.request.contextPath}/pay/index.jsp?BookName="+bookname+"&totalprice="+TotalPrice+"&descr="+Descr+"&OrderId="+OrderId);
				});
			});
		</script>
	</head>
	<body>
		<table class="table-head table-mod">
			<tbody>
				<tr>
					<th width="331px">宝贝</th>
					<th>单价</th>
					<th>数量</th>
					<th>实付款</th>
					<th>交易状态</th>
				</tr>
			</tbody>
		</table>
		<s:iterator value="o1">
		<div class="dom">
			<label>
				<span class="time">
					<input type="checkbox"/>
					<span class="time"><s:date name="OrderTime" format="yyyy-MM-dd"/></span>
				</span>
				<span>
					<span>订单号</span>
					<span>:</span>
					<span id="OrderId"><s:property value="OrderId1"/></span>
				</span>
			</label>
		</div>
		<table class="tb">
		<s:iterator value="itemList" status="st">
			<tr>
				<td width="330px">
					<div style="display: block;">
						<img src="${pageContext.request.contextPath}/productImages/<s:property value="book.BookImg"/>" style="float: left;"/>
						<p style="width: 230px; margin-left:10px; float: left;">
							<a href="javascript::"><span class="sp"><s:property value="book.BookName"/></span></a>
						</p>
					</div>
				</td>
				<td width="238px" align="center">
					<div>
						<p>$<s:property value="DangPrice"/></p>
					</div>
				</td>
				<td width="238px" align="center"><s:property value="Count"/></td>
				<s:if test="#st.count == 1">
				<td class="boder" rowspan="<s:property value="itemList.size()"/>">
					<span id="totalPrice">
					     <s:property value="TotalPrice"/>
					</span>
				</td>
				<span id="descr"><s:property value="book.Describe"/></span>
				<td class="boder" width="239px" rowspan="<s:property value="itemList.size()"/>">
					<div>
					<p>
						<s:if test="state==0">
							 <a id="zhifu" href="${pageContext.request.contextPath}/pay/index.jsp?BookName=<s:property value="book.BookName"/>&totalprice=<s:property value="TotalPrice"/>&descr=<s:property value="book.Describe"/>&OrderId=<s:property value="OrderId1"/>">去付款</a>
						</s:if>
						<s:else>
							<p>交易成功</p>
					        <p>订单详情</p>
						</s:else>
					</p>
				</div>
				</td>
				</s:if>
			</tr>
			</s:iterator>
		</table>
		</s:iterator>
		<div style="margin: 50px;text-align: center;">
				<a href="javascript:history.go(-1);">
				<input 	class="button_1"  type="button" value="取消" /></a>  
	    </div>
	</body>
</html>