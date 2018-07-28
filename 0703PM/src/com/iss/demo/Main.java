package com.iss.demo;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class Main {
	public static void main(String[] args) {
		try {
			
			SAXReader reader = new SAXReader();
			Document document = reader.read("src/person.xml");
			
			Element root = document.getRootElement();
//			System.out.println(root.getName());
			
			List list=root.elements();
			
			for (Object object : list) {
				Element e = (Element) object;
				System.out.print(e.element("name").getText());
				System.out.println("\t"+e.element("name").attributeValue("nn").toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
