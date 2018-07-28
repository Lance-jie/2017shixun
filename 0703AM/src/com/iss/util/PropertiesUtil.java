package com.iss.util;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesUtil {
	public static String getValue(String key) {
		String str = "";
		try {
			
			Properties prop = new Properties();
			InputStream in =new  PropertiesUtil().getClass().getResourceAsStream("./myconfig.properties");
			prop.load(in);
			str = (String)prop.getProperty(key);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}
}
