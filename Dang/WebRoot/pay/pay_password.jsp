<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户支付 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
		<!-- 引入加密js -->
		<script type="text/javascript" src="../js/base64encode.js"></script>
		<script type="text/javascript">
			function pay(){
				window.location.href="<s:url namespace="/hh" action="pay"/>?password="+encode64($("#password").val());
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			支付步骤: <span class="red_bold">1.输入密码</span> > 2.支付成功 >
		</div>
		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					输入支付密码：<input type="password" id="password" />
					<a onclick="pay()"/>点击支付</a>
					<span style="color:red;"><s:property value="msg"/></span>
				</div>
				<ul>
					<li>
						<a href="../main/main.jsp">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

