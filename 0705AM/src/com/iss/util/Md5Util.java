package com.iss.util;
import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
class Md5Util {
	public static String getKillCode(String str) {
		String res = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			res = base64.encode(md5.digest(str.getBytes("utf-8")));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
