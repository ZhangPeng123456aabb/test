<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/hover.js"></script>
		<script type="text/javascript">
		$(function(){
			$("#imgVcode").attr("src","${pageContext.request.contextPath}/validationCode.png");
	});
	//邮箱必须有“@”
    function checkemail(){
	    var emailTxt = document.getElementById("txtEmail");
	    var spanobj = document.getElementById("email.info");
		if(emailTxt.value.indexOf("@")==-1 || emailTxt.value.indexOf(".")==-1){
			spanobj.innerHTML="<font color=red>邮箱地址格式错误</font>";
			return false;
		}
		spanobj.innerText ="";
		return true;
	}
    function checkname(){
       var nameTxt = document.getElementById("txtNickName");
	   var spanobj=document.getElementById("name.info");
	   if(nameTxt.value == ""){
	   	  	spanobj.innerHTML="<font color=red>姓名必填</font>";
	      	return false;
	   }else
	   	spanobj.innerText = "";
	   	return true;
    }
	   // 密码验证
	  function checkPassword(){
       var pwdTxt = document.getElementById("txtPassword");
	   var spanobj=document.getElementById("password.info");
	   if(pwdTxt.value.length < 6){
	   spanobj.innerHTML="<font color=red>密码至少六位</font>";
	      return false;
	   }else
	   spanobj.innerText = "";
	   return true;
      }
      // 再次密码验证
	  function checkPassword1(){
	   var pwdTxt = document.getElementById("txtPassword");
       var pwd1Txt = document.getElementById("txtRepeatPass");
	   var spanobj=document.getElementById("password1.info");
	   if(pwdTxt.value!=pwd1Txt.value){
	   		spanobj.innerHTML="<font color=red>两次输入的密码不同</font>";
	      	return false;
	   }else
	   spanobj.innerText = "";
	   return true;
      }
	// 表单验证
	function checkForm(){
		if (checkemail()==false || checkname()==false || checkPassword()==false || checkPassword1==false)
			return false;
		else
			return true;
	}

		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/user/register" id="f" onsubmit="return checkForm()">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="u.email" type="text" id="txtEmail" class="text_input" onblur="checkemail()"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input onblur="checkname()" name="u.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input onblur="checkPassword()" name="u.password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input onblur="checkPassword1()" name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/validationCode.png"/>
							<input name="validateCode" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a href="javascript:void(0)" onclick="document.getElementById('imgVcode').src='${pageContext.request.contextPath}/validationCode.png?time='+(new Date()).getTime();">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

