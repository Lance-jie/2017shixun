package com.iss.demo;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.iss.util.DBUtil;
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Statement stmt = DBUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from t_book");
			
			//创建文档
			Document doc = DocumentHelper.createDocument();
			
			//创建根节点，并获得根节点的对象
			Element root = doc.addElement("Books");
			Element book = null;
			
			while(rs.next()) {
				//在根节点下创建book子节点，并获取子节点对象
				book =  root.addElement("Book");
				book.addAttribute("BID", rs.getString(1));
				
				//以下是为book创建子节点，并获取子节点的对象
				Element bname = book.addElement("name");
				Element author = book.addElement("author");
				Element price = book.addElement("price");
				Element currPrice = book.addElement("currPrice");
				Element discount = book.addElement("discount");
				Element press = book.addElement("press");
				Element publishtime = book.addElement("publishtime");
				Element edition = book.addElement("edition");
				Element pageNum = book.addElement("pageNum");
				Element wordNum = book.addElement("wordNum");
				Element printtime = book.addElement("printtime");
				//为节点设置数据值
				bname.setText(rs.getString(2));
				author.setText(rs.getString(3));
				price.setText(rs.getString(4));
				currPrice.setText(rs.getString(5));
				discount.setText(rs.getString(6));
				press.setText(rs.getString(7));
				publishtime.setText(rs.getString(8));
				edition.setText(rs.getString(9));
				pageNum.setText(rs.getString(10));
				wordNum.setText(rs.getString(11));
				printtime.setText(rs.getString(12));
			}
		
			
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			
			XMLWriter writer = new XMLWriter(new FileOutputStream(new File("D:/books.xml")),format);
			writer.write(doc);
			
			
			DBUtil.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
