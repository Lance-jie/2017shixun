package com.iss.demo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://10.4.8.21/shixun?useSSL=true&characterEncoding=UTF8", "shixun", "shixun");
			String sql = "select * from users";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//��������
			StringBuffer sb = new StringBuffer();
				
			//׷������
			sb.append("{\"row\":[");
			
			
			while(rs.next()) {
				sb.append("{\"username\":\""+rs.getString(3)+"\",\"userpwd\":\""+rs.getString(4)+"\"},");

			}
			String str = sb.toString().substring(0,sb.toString().length()-1)+"]}";

			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
