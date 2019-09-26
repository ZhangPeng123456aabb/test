package com.baizhi.pay_no_use;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �Զ���У����
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
	 * ����д�ֶ�
	 * 
	 * @param source
	 *            ���ж��ַ���
	 * @return
	 */
	public static boolean required(Object source) {
		if (source == null)
			return false;
		return true;
	}

	/**
	 * �ַ�������
	 * 
	 * @param source
	 *            ���ж��ַ���
	 * @param doTrim
	 *            �Ƿ�ȥ���ո�
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
	 * ����ַ�������
	 * 
	 * @param source
	 *            ���ж��ַ�����Ϊ�ղ����ж�ֱ�ӷ���0
	 * @param minLength
	 *            �����ַ�����,���Ϊ-1���ʾ������
	 * @param maxLength
	 *            �����ַ�����,���Ϊ-1���ʾ������
	 * @return 0��ʾ����Ҫ��������ʾ���Ȳ�����Ҫ�󣬶��ұ�ʾԭ������
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
	 * �ж�Email��ʽ
	 * 
	 * @param source
	 *            ���ж��ַ���
	 * @return
	 */
	public static boolean email(String source) {
		source=source.trim();
		String expression = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		return regex(source, expression, CASE_INSENSITIVE);
	}
	/**
	 * �ж����������ʽ
	 * @param source
	 * @return
	 */
	public static boolean postalCode(String source) {
		source=source.trim();
		String expression="[0-9]{1}(\\d+){5}";
		return regex(source, expression, CASE_SENSITIVE);
	}
	/**
	 * �жϵ绰�ĸ�ʽ
	 * @param source
	 * @return
	 */
	public static boolean phone(String source) {
		source=source.trim();
		String expression="((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
		return regex(source, expression, CASE_INSENSITIVE);
	}
	/**
	 * �ֻ��Ÿ�ʽ
	 * @param source
	 * @return
	 */
	public static boolean mobile(String source) {
		source=source.trim();
		String expression="^((\\(\\d{2,3}\\))|(\\d{3}\\-))?1\\d{10}$";
		return regex(source,expression,CASE_INSENSITIVE);
	}
	/**
	 * �����ж�
	 * 
	 * @param source
	 *            ���ж��ַ���,Ϊ�ջ��߳���Ϊ0ֱ�ӷ���true
	 * @param expression
	 * @return true��ʾ����Ҫ��
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
	 * ȷ�������ַ�����һ����
	 * @param s1 ԭʼ�ַ���
	 * @param s2 ���Ƚ��ַ���
	 * @param isCaseSensitive ��Сд����
	 * @param doTrim ����ո�
	 * @return һ�·���True�����򷵻�false
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
