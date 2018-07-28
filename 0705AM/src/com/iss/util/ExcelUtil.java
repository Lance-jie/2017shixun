package com.iss.util;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;
import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel文件相关操作
 */


import com.iss.po.Book;
public class ExcelUtil {
	
	
	//注意excel文件的扩展名是xlsx
	public static void wirteExcelFile(String fileNme,List<Book> list) {
		try {
			String titleRow[] = {"编号","书名","作者","价格"};
			
			File file = new File(fileNme);
			
			//工作集
			Workbook wb =null;
			
			//sheet页
			Sheet sheet = null;
			
			//在内存中创建excel文件

			wb = new XSSFWorkbook();

			
			//创建sheet页
			sheet = wb.createSheet("图书信息统计表");
			

			
			
			//添加表头
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			
			row.setHeight((short)540);
			cell.setCellValue("库存图书信息");
			
			
			//创建样式
			CellStyle style = wb.createCellStyle();
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setWrapText(true);
			
			
			cell.setCellStyle(style);
			Font font = wb.createFont();
			
			
			font.setFontName("微软雅黑");
			font.setFontHeight((short)280);
			
			style.setFont(font);
			
			
			//将第一行合并单元格,4个参数表示起始行，起始列，结束行，结束列
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 18));
			
			row=sheet.createRow(1);
			
			//动态添加列
			for (int i = 0; i < titleRow.length; i++) {
				cell=row.createCell(i);
				cell.setCellValue(titleRow[i]);
				cell.setCellStyle(style);
				//设置列的宽度
				sheet.setColumnWidth(i, 20*265);
			}
			
			
			//设置第二行的行高
			row.setHeight((short)540);
			
			//循环写入数据
			for(int i=0;i<list.size();i++) {
				
				row = sheet.createRow(i+2);
				row.setHeight((short)500);
				row.createCell(0).setCellValue(list.get(i).getBid());
				row.createCell(1).setCellValue(list.get(i).getBname());
				row.createCell(2).setCellValue(list.get(i).getAuthor());
				row.createCell(3).setCellValue(list.get(i).getPrice());
				row.setRowStyle(style);
			}
			
			//把流和excel文件绑定
			OutputStream outputStream = new FileOutputStream(fileNme);
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void readExcelFile(String fileName) {
		try {
			FileInputStream in = new FileInputStream(fileName);
			
			Workbook wb = new XSSFWorkbook(in);
			
			//第一页
			Sheet sheet = wb.getSheetAt(0);
			//拿到所有行
			Iterator<Row> rows = sheet.rowIterator();
			
			//前两行为非数据内容
			rows.next();
			rows.next();
			String sql = "insert into mbook values(?,?)";
			PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
			//读取数据
			while(rows.hasNext()) {
				Row row = rows.next();
				
				ps.setString(1, row.getCell(1).getStringCellValue());
				ps.setString(2, row.getCell(2).getStringCellValue());
				
				ps.execute();
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
