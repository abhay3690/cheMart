package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.DBConnection;

public class Changepassword {
	
	public boolean validatePassword(int uid,String password) {
		boolean flag = false;
		ResultSet oRs = null;
		PreparedStatement oPrStmt = null;
		try {
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("SELECT pwd FROM users WHERE id=?");
			oPrStmt.setInt(1, uid);
			oRs = oPrStmt.executeQuery();
			if(oRs.next()) {
				String strPwd = oRs.getString("pwd");
				flag = strPwd.equals(password);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	
	
	public String changePassword(String strChangepassword,int id) {
		JSONObject returnJson = new JSONObject();
		PreparedStatement oPrStmt = null;
		try {
			JSONObject changepassword = new JSONObject(strChangepassword);
			String strPassword = changepassword.getString("password");
			String strOldPassword = changepassword.getString("oldPassword");
			if(validatePassword(id,strOldPassword)) {
				Connection con = DBConnection.getConnection();
				oPrStmt = con.prepareStatement("update users set pwd = ? where id=?");
				oPrStmt.setString(1,strPassword);
				oPrStmt.setInt(2, id);
				oPrStmt.executeUpdate();
				returnJson.put("status","success");
			}else {
				returnJson.put("status","Please enter valid current password!");
			}
		}catch(Exception ex) {
			returnJson.put("status","failed");
			ex.printStackTrace();
		}
		return returnJson.toString();
	}

}