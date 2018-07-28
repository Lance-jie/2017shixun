package com.iss.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	public static void Logs(String methodName,String ClassName,
			String currentUser,String sql,String exceptionMsg) {
		
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 24hh:mm:ss");
			String str=sdf.format(new Date());
			System.out.println(str);
			Log.Logs(methodName, ClassName, currentUser, sql, exceptionMsg);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
