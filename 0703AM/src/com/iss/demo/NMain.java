package com.iss.demo;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import com.google.gson.Gson;
import com.iss.po.Users;
import com.iss.util.DBUtil;
import com.iss.util.PropertiesUtil;

public class NMain {

	public static void main(String[] args) {
		try {
			Gson gson = new Gson();

			String sql = "select * from users";
			Statement stmt = DBUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<Users> list = new ArrayList<>();
			
			Users u = null;
			
			while(rs.next()) {
				u = new Users();
				u.setUser_id(rs.getString(2));
				u.setUser_name(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setIntegral(rs.getInt(5));
				u.setPhonenum(rs.getString(6));
				list.add(u);
			}

			System.out.println(gson.toJson(list));
			
			rs.close();
			stmt.close();
			DBUtil.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
