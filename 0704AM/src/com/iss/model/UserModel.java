package com.iss.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserModel {
	private static PreparedStatement ps = null;
	private static Connection connection =null;
	private static ResultSet rs;
	public static int userLogin(String username,String pwd,Connection con) {
		int row=0;
		try {
			String sql = "select count(*) from users where user_name = ? and password = ?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1,username);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
		
			if (rs.next()) {
				row=rs.getInt(1);
			}

			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return row;
	}
	
	public static String translate(String word,Connection con) {
		try {
			String sql = "select mean from dictionary where word = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, word);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
