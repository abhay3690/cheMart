package com.unique.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String userType = request.getParameter("userType");
		int nUserType = Integer.parseInt(userType);
		
		Connection con = null;
		try {
			if(isEmailExists(uemail)) {
				response.getWriter().print("This email address already exists!");
			}else {
				con = DBConnection.getConnection();
				PreparedStatement pst = con
				.prepareStatement("insert into users(ufname,ulname,pwd,email,mobileNo,userType) values(?,?,?,?,?,?)");
				pst.setString(1, ufname);
				pst.setString(2, ulname);
				pst.setString(3, upwd);
				pst.setString(4, uemail);
				pst.setString(5, umobile);
				pst.setInt(6, nUserType);

				int rowCount = pst.executeUpdate();
				if (rowCount <= 0) {
					response.getWriter().print("Someting went wrong, Please contact administrator!");
				}
			}
			
		} catch (Exception e) {
			response.getWriter().print("Someting went wrong, Please contact administrator!");
			e.printStackTrace();
		} finally {
			try {
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isEmailExists(String strEmail) {
		boolean bFlag = false;
		ResultSet oRs = null;
		PreparedStatement oPrStmt = null;
		try {
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("SELECT id FROM users WHERE deleteFlag = 0 and email=?");
			oPrStmt.setString(1, strEmail);
			oRs = oPrStmt.executeQuery();
			if(oRs.next()) {
				bFlag = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
		}
		return bFlag;
	}

}
