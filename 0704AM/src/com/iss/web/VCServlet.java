package com.iss.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VCServlet
 */
@WebServlet("/VCServlet")
public class VCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expries", 0);
		
		//定义验证码图片的宽和高
		int width = 120;
		int height = 30;
		
		//在内存中创建一个图像的对象
		BufferedImage image = new  BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//创建一个画笔
		Graphics g = image.getGraphics();
		
		//给图片添加一个背景
		g.setColor(Color.PINK);
		g.fillRect(1, 1, width-2, height-2);
		
		
		//给边框设置颜色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		
		//设置文本样式
		g.setColor(Color.BLACK);
		g.setFont(new Font("黑体", Font.BOLD|Font.ITALIC, 26));
		
		//给图片添加文字
		Random random = new Random();
		
		int position = 20;
		
		for(int i=0;i<4;i++) {
			g.drawString(random.nextInt(10)+"", position, 22);
			position+=20;
		}
		
		//添加干扰线
		for(int i=0;i<10;i++) {
			//线的颜色
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			
			//线的位置和长短
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		
		ImageIO.write(image, "png", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
