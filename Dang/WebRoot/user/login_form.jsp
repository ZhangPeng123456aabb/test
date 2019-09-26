<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.c1{font-size:14px;color:green}
		    .c2{font-size:14px;color:red}
		</style>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
	    <script type="text/javascript">
	    $(function(){
	    	$("#txtUsername").blur(function(){
			var name=$("#txtUsername").val();
			var reg=/^\w+@\w+\.com$/;
			if(reg.test(name)){
				$("#t1").addClass("c1");
				$("#t1").html("√");
				AA=true;
			}else{
				$("#t1").addClass("c2");
				$("#t1").html("x");
				AA=false;
			}
	    	});
	    	$("#txtPassword").blur(function(){
	    		var pwd = $(this).val();
	    		if(pwd != ""){
	    			$("#t2").addClass("c1");
					$("#t2").html("√");
					BB=true;
	    		}else{
	    			$("#t2").addClass("c2");
					$("#t2").html("x");
					BB=false;
	    		}
	    	});
	    	$("#ctl00").submit(function(){
	    		if(AA && BB){
	    			return true;
	    		}else{
	    			return false;
	    		}
	    	});
		});
	    $(function(){
			$("#imgVcode").attr("src","${pageContext.request.contextPath}/validationCode.png");
	});
	</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form action="${pageContext.request.contextPath}/user/login" id="ctl00" method="post">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="u.email" id="txtUsername" class="textbox" />
									<span id="t1"></span>
								</li>
								
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="u.password" id="txtPassword" class="textbox" />
									<span id="t2"></span>
								</li>
								<li>
									<span class="blank">验证码：</span>
									<input style="width:50px" type="text" name="validateCode"  id="txtPassword"
										class="textbox" /><img id='imgVcode' src="${pageContext.request.contextPath}/validationCode.png" alt="验证码图片" />
								</li>
								 <a href="javascript:void(0)" onclick="document.getElementById('imgVcode').src='${pageContext.request.contextPath}/validationCode.png?time='+(new Date()).getTime();">看不清楚？换个图片</a>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/user/register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>