package com.baizhi.util;

import java.util.Calendar;

public class OrderNoUtil {
	public static String getOrderNo(){
		Calendar ca = Calendar.getInstance();
		int year=ca.get(Calendar.YEAR);
		int month=ca.get(Calendar.MONTH)+1;
		int day=ca.get(Calendar.DATE);
		int hour=ca.get(Calendar.HOUR_OF_DAY);
		int minute=ca.get(Calendar.MINUTE);
		int second=ca.get(Calendar.SECOND);
		int millisecond=ca.get(Calendar.MILLISECOND);
		String no="xuc";
		int random = (int)(Math.random()*10000);
		no=no+random+year;
		if(month<10){
			no=no+"0"+month;
		}else{
			no+=month;
		}
		if(day<10){
			no=no+"0"+day;
		}else{
			no+=day;
		}
		if(hour<10){
			no=no+"0"+hour;
		}else{
			no+=hour;
		}
		if(minute<10){
			no=no+"0"+minute;
		}else{
			no+=minute;
		}
		if(second<10){
			no=no+"0"+second;
		}else{
			no+=second;
		}
		if(millisecond>=10&&millisecond<100){
			no=no+"0"+millisecond;
		}else if(millisecond<10){
			no=no+"00"+millisecond;
		}else{
			no+=millisecond;
		}
		return no;
	}

}
