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

import org.json.JSONObject;

import utils.DBConnection;

public class Users extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject userObj = new JSONObject();
		HttpSession session = request.getSession();
		String strUid = session.getAttribute("uid").toString();
		
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement pst =con.prepareStatement("select * from users where id = ? and deleteFlag = 0 ");
			pst.setString(1,strUid);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				userObj.put("uid",rs.getInt("id"));
				userObj.put("fname",rs.getString("ufname"));
				userObj.put("lname",rs.getString("ulname"));
				userObj.put("email",rs.getString("email"));
				userObj.put("mobileNo",rs.getString("mobileNo"));
				userObj.put("userType",rs.getInt("userType"));
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(userObj.toString());
			}else {
				response.getWriter().print("No user found!");
			}
			
		} catch (Exception e) {
			response.getWriter().print("Someting went wrong, Please contact administrator!");
			e.printStackTrace();
		}
	}
}
