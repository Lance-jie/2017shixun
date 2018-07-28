package com.iss.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iss.model.UserModel;
import com.iss.po.MSG;
import com.iss.util.DBUtil;


/**
 * Servlet implementation class usersServlet
 */
@WebServlet("/usersServlet")
public class usersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public usersServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
//			String username = request.getParameter("txtName");
//			String pwd =  request.getParameter("txtPwd");
//			System.out.println("username:"+username+"\tpwd:"+pwd);
//			int row=UserModel.userLogin(username, pwd, DBUtil.getConnection());
//			
//			System.out.println(row);
//			if (row==1){
//				response.sendRedirect("main.jsp");
//			}
			
			String word =  request.getParameter("word");
			System.out.println("word:"+word);
			String mean = UserModel.translate(word, DBUtil.getConnection());
			
			
			
			MSG m = new MSG();
			if (mean!=null) {
				m.setMsg(mean);
				m.setState("OK");
			}else {
				m.setMsg("失败");
				m.setState("faile");
			}
			
			out.print((new Gson()).toJson(m));
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	
	}
}
