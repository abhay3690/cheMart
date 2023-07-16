package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.DBConnection;

public class Product {
	
	public String getProducts() {
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
				jsonObj.put("enrollment", oRs.getInt("enrollmentNo"));
				jsonObj.put("fname",oRs.getString("fname"));
				jsonObj.put("lname",oRs.getString("lname"));
				jsonObj.put("dob",oRs.getString("dob"));
				jsonObj.put("gender",oRs.getString("gender"));
				jsonObj.put("mobileno",oRs.getString("mobileno"));
				jsonObj.put("address",oRs.getString("address"));
				jsonObj.put("city",oRs.getString("city"));
				jsonObj.put("state",oRs.getString("state"));
				oJsonArray.put(jsonObj);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}

}
