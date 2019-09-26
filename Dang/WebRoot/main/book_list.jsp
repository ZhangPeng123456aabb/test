<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='#'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${requestScope.category_name}</strong></font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<strong>&middot;<s:property value="c.category_name"/>&nbsp;(23)</strong>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<s:iterator value="c.category">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath}/category/c_TestshowPageCategory?Id=<s:property value="category_id"/>&parent_id=<s:property value="parent_id"/>"><s:property value="category_name"/>&nbsp;(10)</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						    </s:iterator>
							<!--2级分类结束-->
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="#">
								<img src='../images/page_up.gif' /> </a>
							</div>
	
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
				
							<div class='list_r_title_text3b'>
							<c:if test="${requestScope.page ==1}" >
								上一页
					        </c:if>
					        <c:if test="${requestScope.page>1 }">
					   		    <a class="paginate_button" id="next" href="${pageContext.request.contextPath }/category/c_TestshowPageCategory?page=${requestScope.page-1}&rows=${requestScope.rows}&c.category_id=${requestScope.category_id}&parent_id=${requestScope.parent_id}">上一页</a>
					         </c:if>
					   
					        <c:forEach begin="1" end="${requestScope.totalPage }" varStatus="vs">
						      <a  href="${pageContext.request.contextPath }/category/c_TestshowPageCategory?page=${vs.count }&rows=${requestScope.rows}&Id=${requestScope.category_id}&parent_id=${requestScope.parent_id}">${vs.count }</a>&nbsp;
					       </c:forEach>
					
					       <c:if test="${requestScope.page == requestScope.totalPage}">
						      下一页  
					       </c:if>
					        <c:if test="${requestScope.page < requestScope.totalPage}">
						       <a class="paginate_button" id="next" href="${pageContext.request.contextPath }/category/c_TestshowPageCategory?page=${requestScope.page+1}&rows=${requestScope.rows}&Id=${requestScope.category_id}&parent_id=${requestScope.parent_id}">下一页</a>
				        	</c:if>
							</div>
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="#">
									<img src='../images/page_down.gif' /> </a>
							</div>
			
							
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<s:iterator value="bookList">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="${pageContext.request.contextPath}/productImages/<s:property value="BookImg"/>"></a></span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath}/book/b_SelectOneBook?b.BookId=<s:property value="BookId"/>'><s:property value="BookName"/></a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name=''><s:property value="Author"/></a>
							</h4>
							<h4>
								出版社：
								<a href='#' name=''><s:property value="Press"/></a>
							</h4>
							<h4>
								出版时间:<s:date name="date" format="yyyy-MM-dd"/>
							</h4>
							<h5>
								<s:property value="Describe"/>
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="BookPrice"/></span>
								<span class="red">￥<s:property value="DangPrice"/></span>
								节省：￥<s:property value="BookPrice-DangPrice"/>
							</h6>
							<span class="list_r_list_button"> 
							<a href="#"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
						</s:iterator>
						<div class="clear"></div>
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
