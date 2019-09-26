<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
		 <script type="text/javascript">
				
					$(function(){
						$("a[name='change']").click(function(){
							var count=$(this).prev().val();
							var bookId=$(this).next().html();
							$(this).prop("href","${pageContext.request.contextPath}/cart/updateCart?bookId="+bookId+"&buyCount="+count);
						})
					})
					/*  $("[name='jiesuan']").click(function(){
						var cart=$(this).prev().html();
						var a=$(this).parent();
						console.log(cart);
						if(cart==""||cart=="0"){
							alert("您还未购买商品，请先购买商品！");
						}else{
							a.prop("href","../order/order_info.jsp");
						}
					});  */
					$(function(){
						$("[name='delete']").click(function(){
							var bookId=$("a[name='change']").next().html();
							/* $("a[name='change']").parent().parent().remove(); */
							$(this).prop("href","${pageContext.request.contextPath}/cart/deleteCart?bookId="+bookId); 
						});
					});
				
		</script> 
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>封面</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
                      <!-- 购物列表开始 -->
                      <s:iterator value="#session.cart.addMap">
						<tr class='td_no_bord'>
							<td class="buy_td_6">
								<span ><img src="../productImages/<s:property value="value.book.BookImg"/>" height="50px" width="58px"/></span>
							</td>
							<td>
								<span class="span_w1"><a href="#"><s:property value="value.book.BookName"/></a></span>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥<s:property value="value.book.BookPrice"/></span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥<s:property value="value.book.DangPrice"/></span>
							</td>
							<td class="buy_td_1">
								<span><s:property value="value.buyCount"/></span>
							</td>

							<td >
								<input class="del_num" type="text" size="3" maxlength="4"/>
								<a href="javaSrcipt:void(o)" name="change">变更</a>
								<span style="display:none"><s:property value="value.book.bookId"/></span>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/cart/deleteCart?bookId=<s:property value="value.book.bookId"/>" name="delete">删除</a>
							</td>
						</tr>
						</s:iterator>
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='${pageContext.request.contextPath}/category/c_showCategory'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy"><s:property value="#session.cart.savePrice"/></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'><s:property value="#session.cart.totalPrice"/></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${pageContext.request.contextPath}/address/a_selectAllAddress1' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
					<s:iterator value="#session.cart.removeMap">
					<tr>
						<td width="58" class=buy_td_6>
							<span><img src="../productImages/<s:property value="value.book.BookImg"/>" height="50px" width="58px"/></span>
						</td>
						<td width="365" class=t2>
							<a href="#"><s:property value="value.book.BookName"/></a>
						</td>
						<td width="106" class=buy_td_5>
							￥<s:property value="value.book.BookPrice"/>
						</td>
						<td width="134" class=buy_td_4>
							<span>￥<s:property value="value.book.DangPrice"/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath }/cart/recoverCart?bookId=<s:property value="value.book.bookId"/>">恢复</a>	
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					</s:iterator>


					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>


				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



