<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function checkname() {
	var nameTxt = document.getElementById("receiveName");
	var spanobj = document.getElementById("name.info");
	if (nameTxt.value == "") {
		spanobj.innerHTML = "<font color=red>名字不能为空</font>";
		return false;
	} else
		spanobj.innerText = "";
	return true;
}

function checkeaddress() {
	var addressTxt = document.getElementById("fullAddress");
	var spanobj = document.getElementById("address.info");
	if (addressTxt.value == "") {
		spanobj.innerHTML = "<font color=red>地址不能为空</font>";
		return false;
	}
	spanobj.innerText = "";
	return true;
}

function checkmobile() {
	var mobileTxt = document.getElementById("phone");
	var spanobj = document.getElementById("telphone.info");
	var reg = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
	if (!reg.test(mobileTxt.value)) {
		spanobj.innerHTML = "<font color=red>请填写正确的手机号</font>";
		return false;
	} else
		spanobj.innerText = "";
	return true;
}

// 表单验证
function checkForm() {
	if (checkname() & checkeaddress() & checkmobile())
		return true;
	else
		return false;
}
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		添加收货地址：
	</div>
	<div class="fill_message">
	
		<form name="ctl00" action="${pageContext.request.contextPath}/address/a_insertAddress"
			method="post" onsubmit="return checkForm()" id="f" >
			<input type="hidden" name="UserId" id="addressId" />
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input  type="text"  onblur="checkname()" class="text_input"
						name="ddr.receive_name" id="receiveName"/>
						<div class="text_left" id="nameValidMsg">
							<p id="p1">请填写有效的收件人姓名</p>
							<span id="name.info" style="color:red"></span>
						</div></td> 
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input  type="text" onblur="checkeaddress()"
						name="ddr.address" class="text_input" id="fullAddress"/>
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
							<span id="address.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input  type="text" onblur="checkmobile()"
						class="text_input" name="ddr.telphone" id="phone" />
						<div class="text_left" id="phoneValidMsg">
							<p>请填写有效的收件人的手机</p>
							<span id="telphone.info" style="color:red"></span>
						</div></td>
				</tr>
			</table>

			<div class="login_in">
				<a href="javascript:history.go(-1);"><input id="btnClientRegister"
					class="button_1"  type="button" value="取消" /></a> <input
					id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="添加" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

