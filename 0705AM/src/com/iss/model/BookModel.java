package com.iss.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iss.po.Book;




public class BookModel {
	public static List<Book> getBookList(Connection con){
		List<Book> list = null;
		try {
			Statement stmt = con.createStatement();
			String sql="select * from t_book";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			Book book = null;
			while(rs.next()) {
				book = new Book();
				
				book.setBid(rs.getString(1));
				book.setBname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				
				
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
}
