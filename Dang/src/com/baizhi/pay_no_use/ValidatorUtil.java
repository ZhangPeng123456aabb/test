package com.baizhi.pay_no_use;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义校验器
 * 
 * @author Mr.rong
 * 
 */
public class ValidatorUtil {
	public static boolean CASE_SENSITIVE = true;
	public static boolean CASE_INSENSITIVE = false;
	public static boolean DO_TRIM=true;
	public static boolean DO_NOT_TRIM=false;
	/**
	 * 必填写字段
	 * 
	 * @param source
	 *            被判断字符串
	 * @return
	 */
	public static boolean required(Object source) {
		if (source == null)
			return false;
		return true;
	}

	/**
	 * 字符串必填
	 * 
	 * @param source
	 *            被判断字符串
	 * @param doTrim
	 *            是否去掉空格
	 * @return
	 */
	public static boolean requiredString(String source, boolean doTrim) {
		if (doTrim) {
			source = source.trim();
		}
		if (source.length() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 检查字符串长度
	 * 
	 * @param source
	 *            被判断字符串，为空不做判断直接返回0
	 * @param minLength
	 *            至少字符个数,如果为-1则表示不限制
	 * @param maxLength
	 *            至多字符个数,如果为-1则表示不限制
	 * @return 0表示符合要求，正数表示长度不符合要求，而且表示原串长度
	 */
	public static int stringLength(String source, int minLength, int maxLength,
			boolean doTrim) {
		if (source == null || source.length() <= 0) {
			return 0;
		}
		if (doTrim) {
			source = source.trim();
			if (source.length() <= 0) {
				return 0;
			}
		}

		if ((minLength > -1) && (source.length() < minLength)) {
			return source.length();
		} else if ((maxLength > -1) && (source.length() > maxLength)) {
			return source.length();
		}
		return 0;
	}

	/**
	 * 判断Email格式
	 * 
	 * @param source
	 *            被判断字符串
	 * @return
	 */
	public static boolean email(String source) {
		source=source.trim();
		String expression = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		return regex(source, expression, CASE_INSENSITIVE);
	}
	/**
	 * 判断邮政编码格式
	 * @param source
	 * @return
	 */
	public static boolean postalCode(String source) {
		source=source.trim();
		String expression="[0-9]{1}(\\d+){5}";
		return regex(source, expression, CASE_SENSITIVE);
	}
	/**
	 * 判断电话的格式
	 * @param source
	 * @return
	 */
	public static boolean phone(String source) {
		source=source.trim();
		String expression="((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
		return regex(source, expression, CASE_INSENSITIVE);
	}
	/**
	 * 手机号格式
	 * @param source
	 * @return
	 */
	public static boolean mobile(String source) {
		source=source.trim();
		String expression="^((\\(\\d{2,3}\\))|(\\d{3}\\-))?1\\d{10}$";
		return regex(source,expression,CASE_INSENSITIVE);
	}
	/**
	 * 正则判断
	 * 
	 * @param source
	 *            被判断字符串,为空或者长度为0直接返回true
	 * @param expression
	 * @return true表示符合要求
	 */
	public static boolean regex(String source, String expression,
			boolean isCaseSensitive) {
		if (source == null || expression == null) {
			return true;
		}

		String str = source.trim();
		if (str.length() == 0) {
			return true;
		}

		// match against expression
		Pattern pattern;
		if (isCaseSensitive) {
			pattern = Pattern.compile(expression);
		} else {
			pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		}

		String compare = source;

		Matcher matcher = pattern.matcher(compare);

		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
	/**
	 * 确定两个字符串的一致性
	 * @param s1 原始字符串
	 * @param s2 被比较字符串
	 * @param isCaseSensitive 大小写敏感
	 * @param doTrim 允许空格
	 * @return 一致返回True，否则返回false
	 */
	public static boolean stringEquals(String s1,String s2,boolean isCaseSensitive,boolean doTrim) {
		if(s1==null && s2==null) {
			return true;
		}
		if(doTrim) {
			s1=s1.trim();
			s2=s2.trim();
		}
		if(s1.length()==0 && s2.length()==0) {
			return true;
		}
		if(isCaseSensitive) {
			return s1.equals(s2);
		}
		else {
			return s1.equalsIgnoreCase(s2);
		}
	}
}
