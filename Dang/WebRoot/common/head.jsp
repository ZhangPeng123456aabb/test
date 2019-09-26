<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
	<style type="text/css">
		#search_box { background: -moz-linear-gradient(top, #ffd73a, #ffa500); background: -webkit-gradient(linear, 0 0, 0 100%, from(#ffd73a), to(#ffa500)); border: 1px solid #d28703; border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; -moz-box-shadow: inset 0 1px #ffff90, inset 0 -2px 5px #ffd05d, 0 0 0 4px rgba(255,255,255,0.65); -webkit-box-shadow: inset 0 1px #ffff90, inset 0 -2px 5px #ffd05d, 0 0 0 4px rgba(255,255,255,0.65); padding: 6px; width: 570px; margin-left: 171px;}
		#search_box .wrapper { background: #fff; border: 1px solid #d28703; -moz-border-radius: 2px; -webkit-border-radius: 2px; -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,.3), 0 1px #ff0; -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,.3), 0 1px #ff0; height: 50px; padding-left: 10px; position: relative; }
		#search_box input, #search_box input:focus { border: none; color: #333; outline: none; font: bold 24px Helvetica, Arial, sans-serif;  width: 510px; }
		#search_box button { background: -moz-linear-gradient(top, #453e26, #000); background: -webkit-gradient(linear, 0 0, 0 100%, from(#453e26), to(#000)); border: 1px solid #000; -moz-border-radius: 2px; -webkit-border-radius: 2px; -moz-box-shadow: inset 0 -2px 3px #193544, inset 0 1px #907817, 0 1px 1px rgba(0,0,0,4); -webkit-box-shadow: inset 0 -2px 3px #193544, inset 0 1px #907817, 0 1px 1px rgba(0,0,0,.4); cursor: pointer;  width: 37px; margin-left: 11px; margin-top: -16px;}
		h1 { margin-bottom: 0; }
		</style>
	<link href="${pageContext.request.contextPath }/css/book_head090107.css" rel="stylesheet" type="text/css" />
	<script>
	   
	</script>
</head>
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="${pageContext.request.contextPath}/address/a_selectAllAddress" name="myaddress" class="head_black12a">我的收货地址</a>
					| <a href="${pageContext.request.contextPath}/orderitem/showOrderItem" name="mydangdang" class="head_black12a">我的订单</a> | <a
					href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
			<div class="cart gray4012">
				<a href="${pageContext.request.contextPath}/cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好${sessionScope.user.nickname}，欢迎光临当当网</b>
		
		
		[&nbsp;<a href="${pageContext.request.contextPath}/user/Exit" class="b">登出</a>&nbsp;]
		[&nbsp;<a href="${pageContext.request.contextPath}/user/Exit" class="b">登录</a>|<a
			href="${pageContext.request.contextPath}/user/register_form.jsp" class="b">注册</a>&nbsp;]
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="#" name="backtobook"><img
						src="${pageContext.request.contextPath}/images/booksaleimg/book_logo.gif" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="wrapper" id="search_box"><!-- head_search_div -->
		<form action="${pageContext.request.contextPath }/book1/b1_PageBySearchOneBook" method="post">
			<input type="text" id="search" name="bb.BookName" placeholder="Search for Book">
			
			<button type="submit" class="search_btn"><img width="37px" height="37px" src="${pageContext.request.contextPath }/images/search1.jpg" title="Search"/></button>	
		</form>
	</div>
	<div class="head_search_bg"></div>
</div>
