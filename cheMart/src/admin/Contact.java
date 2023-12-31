



package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.DBConnection;

public class Contact {
	
	public String getContact() {
		JSONObject jsonObj = null;
		JSONArray oJsonArray= new JSONArray();
		ResultSet oRs = null;
		Statement oStmt = null;
		try {
			Connection con = DBConnection.getConnection();
			oStmt = con.createStatement();
			oRs = oStmt.executeQuery("SELECT * FROM product WHERE deleteFlag = 0");
			while(oRs.next()) {
				jsonObj = new JSONObject();
				jsonObj.put("id", oRs.getInt("id")) ;
				jsonObj.put("firstname",oRs.getString("firstname"));
				jsonObj.put("lastname",oRs.getDouble("lastname"));
				jsonObj.put("email",oRs.getString("email"));
				jsonObj.put("message",oRs.getString("message"));
				oJsonArray.put(jsonObj);
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}
	
	
	
	public String addContact(String strContact) {
		JSONObject returnJson = new JSONObject();
		PreparedStatement oPrStmt = null;
		try {
			JSONObject contact = new JSONObject(strContact);
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("INSERT INTO message(firstname,lastname,email,message) values(?,?,?,?)");
			oPrStmt.setString(1,contact.getString("fname"));
			oPrStmt.setString(2, contact.getString("lname"));
			oPrStmt.setString(3, contact.getString("email"));
			oPrStmt.setString(4, contact.getString("message"));
			oPrStmt.executeUpdate();
			returnJson.put("status","success");
		}catch(Exception ex) {
			returnJson.put("status","failed");
			ex.printStackTrace();
		}
		return returnJson.toString();
	}

}
