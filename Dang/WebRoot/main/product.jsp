<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}

			#f{
				border: 1px red dashed;
				background-color: aqua;
			}
			#f1{
				border: 1px red dashed;
				background-color: aqua;
			}
			.first{
				width: 20%;
				text-align: center;
				color: #C12E2A;
			}
			.second{
				width: 80%;
				padding-bottom: 0px;
			}
			tr{
				height: 80px;
			}
			table{
				width: 900px;
			}
			.huifu{
				margin-left: 400px;
				background-color: gainsboro;
			}
			.name{
				color: #C12E2A;
			}
			.comment{
				padding-left:55px;
			}
</style>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}

			#f{
				border: 1px red dashed;
				background-color: aqua;
			}
			#f1{
				border: 1px red dashed;
				background-color: aqua;
			}
			.first{
				width: 20%;
				text-align: center;
				color: #C12E2A;
			}
			.second{
				width: 80%;
				padding-bottom: 0px;
			}
			tr{
				height: 80px;
			}
			table{
				width: 900px;
			}
			.huifu{
				margin-left: 400px;
				background-color: gainsboro;
			}
			.name{
				color: #C12E2A;
			}
			.comment{
				padding-left:55px;
			}
</style>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/kindEditor/themes/default/default.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/kindEditor/plugins/code/prettify.css"/>
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindEditor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindEditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindEditor/plugins/code/prettify.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<script>
	$(function(){
		$("[name='mai']").click(function(){
			var img = $(this);
			var bookId=img.next().html();
				$.ajax({
					url:'${pageContext.request.contextPath}/cart/addCart',
					data:'bookId='+bookId
				});
			window.setTimeout(function(){
				img.prop("src","${pageContext.request.contextPath}/images/load.gif");
			},500);
			window.setTimeout(function(){
				img.prop("src","${pageContext.request.contextPath}/images/label3.gif");
			},1000);
			window.setTimeout(function(){
				img.prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
			},1500);
		});
	});
	
</script>

</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				
			</h1>
			<span><font color="#cccccc">丛书名：<s:property value="b.BookName"/></font></span>
			<hr />
			<div>
				<div style="float: left;width:20%;">
					<img src="${pageContext.request.contextPath}/productImages/<s:property value="b.BookImg"/>"  border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：<s:property value="b.Author"/></li>
						<li>出版社：<s:property value="b.Press"/></li>
						<li style="float:left;width:50%;">出版时间：<s:date name="b.date" format="yyyy-MM-dd"/></li>
						<li style="float:left;width:50%;">字数:10000字</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">版次：第一版</li>
						<li style="float:left;width:50%;">页数：6666</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印刷时间：8758</li>
						<li style="float:left;width:50%;">开本：5246	</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印次：56</li>
						<li style="float:left;width:50%;">纸张：A4</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">ISBN：3246</li>
						<li style="float:left;width:50%;">包装：开本</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='${pageContext.request.contextPath}/category/c_showCategory'>当当图书</a> &gt;&gt;
								<s:property value="ca.category_name"/>&gt;&gt;
								<font style='color: #cc3300'>
									<s:iterator value="ca.category">
										<strong> 
										    <s:property value="category_name"/> 
										</strong>
									</s:iterator> 
								</font>
							</div>
						</li>
						<li>定价：<s:property value="b.BookPrice"/>￥&nbsp;&nbsp;
							当当价：<s:property value="b.DangPrice"/>￥&nbsp;&nbsp; 节省：<s:property value="b.BookPrice-b.DangPrice"/>￥</li>
						<li>
						<img name="mai" src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="abc"/>
						<span style="display:none"><s:property value="b.BookId"/></span>
						</li>

					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>
		
		
		<div>
			<fieldset id="f">
				<legend id="f1">用户评论区</legend>
				<table id="table" border="1"  cellpadding="4" cellspacing="0">
				<tbody>
				<c:forEach items="${requestScope.comment}" var="co" varStatus="status">
				<tr>
					<td class="first">${co.nickname}</td>
					<td class="second">${co.CommentContent}
						<div class="huifu">
						<c:forEach items="${co.commentList}" var="com">
							<p>
							<span class="name">${com.nickname }:</span>${com.CommentContent}     
							</p>
							<p align="right"><fmt:formatDate value="${com.CommentDate}"  pattern="yyyy年MM月dd日"/></p>
						</c:forEach>
						</div>
						<form style="display:none">
					      <p align="right">
					      <textarea name="content1" style="width:400px;height:100px;"></textarea>
					      </p>
					      <p align="right">
					      <a href="javascript:void(0)" name="up">收起↑↑↑↑</a>
					      <input type="button" name="getHtml1" value="评论" />
					      <span style="display:none">${co.CommentId}</span>
					      </p>
					   </form>
					     <p align="right">${co.status}楼   <fmt:formatDate value="${co.CommentDate}"  pattern="yyyy年MM月dd日"/><a href="javascript:void(0)" name="reply">回复</a></p>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			</fieldset>
		</div>
		<div class="comment">
			<form name="example" method="post" action="${pageContext.request.contextPath}/comment/com_addComment?b.BookId=<s:property value="b.BookId"/>">
			<textarea name="comment1.CommentContent" class="ckeditor" style="width:800px;height:400px;"></textarea>
				<input type="submit" name="提交"/>
			</form>
		</div>
	</div>
</body>
</html>