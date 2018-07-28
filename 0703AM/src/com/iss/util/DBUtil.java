package com.iss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.iss.util.PropertiesUtil;

public class DBUtil {
	
	private static  Connection con=null;
	private static String driverName = PropertiesUtil.getValue("driverName");
	private static String url = PropertiesUtil.getValue("url");
	private static String username = PropertiesUtil.getValue("username");
	private static String userpassword = PropertiesUtil.getValue("userpassword");
	public static Connection getConnection() {
		try {
			if (con==null) {
				Class.forName(driverName);
				con = DriverManager.getConnection(url,
						username, userpassword);
			}
		} catch (Exception e) {
			// TODO: handle exception
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
