$(document).ready(function(){
	/**一级内容悬浮**/
	$("li").mouseover(function(){
		$(this).css({"background":"orange"});//当前li 背景颜色为橙色

		$(this).children("div").show();//让相应二级内容显示
		
	}).mouseout(function(){
			 $(this).css({"background":"#c81623"});
			$(this).children("div").hide();

	});
});