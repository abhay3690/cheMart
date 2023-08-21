package com.unique.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBConnection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uemail=request.getParameter("username");

		String upwd=request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement pst =con.prepareStatement("select * from users where uemail = ? and upwd = ? ");
			pst.setString(1,uemail);
			pst.setString(2,upwd);
			
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				session.setAttribute("name",rs.getString("uname"));
				response.sendRedirect("/cheMart/jsp/myAccount/index.jsp");
			}else {
//				request.setAttribute("status", "failed");
				response.sendRedirect("/cheMart/jsp/myAccount/login.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
