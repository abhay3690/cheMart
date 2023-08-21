package com.unique.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBConnection;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ufname = request.getParameter("fname");
		String ulname = request.getParameter("lname");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("password");
		String umobile = request.getParameter("contact");

		Connection con = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con
			.prepareStatement("insert into users(ufname,ulname,pwd,email,mobileNo) values(?,?,?,?,?)");
			pst.setString(1, ufname);
			pst.setString(2, ulname);
			pst.setString(3, upwd);
			pst.setString(4, uemail);
			pst.setString(5, umobile);

			int rowCount = pst.executeUpdate();
			if (rowCount <= 0) {
				response.getWriter().print("Someting went wrong, Please contact administrator!");
			}			
		} catch (Exception e) {
			response.getWriter().print("Someting went wrong, Please contact administrator!");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
