+<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		#search_box { background: -moz-linear-gradient(top, #ffd73a, #ffa500); background: -webkit-gradient(linear, 0 0, 0 100%, from(#ffd73a), to(#ffa500)); border: 1px solid #d28703; border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; -moz-box-shadow: inset 0 1px #ffff90, inset 0 -2px 5px #ffd05d, 0 0 0 4px rgba(255,255,255,0.65); -webkit-box-shadow: inset 0 1px #ffff90, inset 0 -2px 5px #ffd05d, 0 0 0 4px rgba(255,255,255,0.65); padding: 6px; width: 570px; margin-left: 171px;}
		#search_box .wrapper { background: #fff; border: 1px solid #d28703; -moz-border-radius: 2px; -webkit-border-radius: 2px; -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,.3), 0 1px #ff0; -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,.3), 0 1px #ff0; height: 50px; padding-left: 10px; position: relative; }
		#search_box input, #search_box input:focus { border: none; color: #333; outline: none; font: bold 24px Helvetica, Arial, sans-serif;  width: 510px; }
		#search_box button { background: -moz-linear-gradient(top, #453e26, #000); background: -webkit-gradient(linear, 0 0, 0 100%, from(#453e26), to(#000)); border: 1px solid #000; -moz-border-radius: 2px; -webkit-border-radius: 2px; -moz-box-shadow: inset 0 -2px 3px #193544, inset 0 1px #907817, 0 1px 1px rgba(0,0,0,4); -webkit-box-shadow: inset 0 -2px 3px #193544, inset 0 1px #907817, 0 1px 1px rgba(0,0,0,.4); cursor: pointer;  width: 37px; margin-left: 11px; margin-top: -16px;}
		h1 { margin-bottom: 0; }
		</style>
	<link href="/ssmdangdang/css/book_head090107.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank">
			<img src="../images/default/book_banner_081203.jpg" border="0" /></a>
		</div>
		<div class="book">
			<!--左栏开始-->
			<div id="left" class="book_left">
			<div class="book_l_border1" id="__FenLeiLiuLan">
	        <div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始-->
		<s:iterator value="CategoryList">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href="${pageContext.request.contextPath}/category/c_TestshowPageCategory?c.category_id=<s:property value="category_id"/>&c.category_name=<s:property value="category_name"/>"><s:property value="category_name"/></a>]
				</h3>
				<!--2级分类开始-->
				<s:iterator value="category">
				<ul class="ul_left_list">
						<li>
							<a href="${pageContext.request.contextPath}/category/c_TestshowPageCategory?Id=<s:property value="category_id"/>&parent_id=<s:property value="parent_id"/>"><s:property value="category_name"/></a>
						</li>
						<!--2级分类结束-->
				</ul>
				</s:iterator>
				<div class="empty_left">
				</div>
				</div>
				<div class="more2">
			    </div>
			    </s:iterator>
			    <!--1级分类结束-->
						<div class="bg_old">
							<h3>
								&nbsp;
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">
				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
						<h2>
							<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>编辑推荐
						</h2>
				<div id=__bianjituijian/danpin>
					<div class=second_c_02>
					<s:iterator value="AuthorList">
						<div class=second_c_02_b1>
							<div class=second_c_02_b1_1>
								<a href='#' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value="BookImg"/>" width=70 border=0 /> </a>
							</div>
							<div class=second_c_02_b1_2>
								<h3>
									<a href='${pageContext.request.contextPath}/comment/com_showComment?b.BookId=<s:property value="BookId"/>' target='_blank'><s:property value="BookName"/></a>
								</h3>
								<h4>
									作者：<s:property value="Author"/> 著
									<br />
									出版社：<s:property value="Press"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:date name="date" format="yyyy年MM月dd日"/>
								</h4>
								<h5>
									<span class="pot"><s:property value="Describe"/></span>
								</h5>
								<h6>
									定价：￥<s:property value="BookPrice"/>&nbsp;&nbsp;当当价：￥<s:property value="DangPrice"/>
								</h6>
							<div class=line_xx></div>
						</div>
					</div>
					</s:iterator>
				</div>
				</div>
				</div>
				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<h2>
						<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
					</h2>
				<div class="book_c_04">
					<!--热销图书A开始-->
					<s:iterator value="BookList">
					<div class="second_d_wai">
						<div class="img">
							<a href="#" target='_blank'><img
									src="${pageContext.request.contextPath}/productImages/<s:property value="BookImg"/>" border=0 /> </a>
						</div>
						<div class="shuming">
							<a href="${pageContext.request.contextPath}/comment/com_showComment?b.BookId=<s:property value="BookId"/>" target="_blank"><s:property value="BookName"/></a><a href="#" target="_blank"></a>
						</div>
						<div class="price">
							定价：￥<s:property value="BookPrice"/>
						</div>
						<div class="price">
							当当价：￥<s:property value="DangPrice"/>
						</div>
					</div>
					<div class="book_c_xy_long"></div>
					</s:iterator>
					<!--热销图书A结束-->
				</div>
				<div class="clear"></div>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
					</h2>
				<div class="book_c_04">
					<!--热销图书A开始-->
					<s:iterator value="BookTimeList">
					<div class="second_d_wai">
						<div class="img">
							<a href="#" target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value="BookImg"/>" border=0 /> </a>
						</div>
						<div class="shuming">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/comment/com_showComment?b.BookId=<s:property value="BookId"/>" target="_blank"><s:property value="BookName" /></a><a href="#" target="_blank"></a>
						</div>
						<div class="price">
							定价：￥<s:property value="BookPrice" />
						</div>
						<div class="price">
							当当价：￥<s:property value="DangPrice"/>
						</div>
					</div>
					<div class="book_c_xy_long"></div>
					<!--热销图书A结束-->
					</s:iterator>
				</div>
				<div class="clear"></div>
				</div>
				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
							<h3 class="second">
							<s:iterator value="BookCount">
								<ul>
									 <li><a href="${pageContext.request.contextPath}/comment/com_showComment?b.BookId=<s:property value="BookId"/>" target='_blank'><s:property value="BookName"/></a></li>
								</ul>
								</s:iterator>
								<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>

			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->

		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />
        <div class="public_footer">
	    <div class="public_footer_bottom">
		<div class="public_footer_icp" style="line-height: 48px;">
			Copyright (C) 当当网 2004-2008, All Rights Reserved
			<a href="#" target="_blank"><img
					src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
			<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
		</div>
	</div>
</div>

		<!--页尾结束 -->
	</body>
</html>
