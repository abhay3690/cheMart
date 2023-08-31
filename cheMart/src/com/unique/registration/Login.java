package com.unique.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
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
		
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement pst =con.prepareStatement("select * from users where email = ? and pwd = ? ");
			pst.setString(1,uemail);
			pst.setString(2,upwd);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				session.setAttribute("uid", rs.getInt("id"));
				session.setAttribute("userType", rs.getInt("userType"));
				session.setAttribute("name",rs.getString("ufname")+" "+rs.getString("ulname"));
			}else {
				response.getWriter().print("Username or password is incorrect!");
			}
			
		} catch (Exception e) {
			response.getWriter().print("Someting went wrong, Please contact administrator!");
			e.printStackTrace();
		}
	}

}
