package com.baizhi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String encrypt(String password) throws NoSuchAlgorithmException{
		MessageDigest md=MessageDigest.getInstance("md5");
		byte[] bytes = password.getBytes();
		md.update(bytes);
		BigInteger bi=new BigInteger(md.digest());
		return bi.toString();
	}

}
