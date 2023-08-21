package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.DBConnection;

public class Category {
	public String getCompanyCategoryList() {
		JSONObject jsonObj = null;
		JSONArray oJsonArray= new JSONArray();
		ResultSet oRs = null;
		Statement oStmt = null;
		try {
			Connection con = DBConnection.getConnection();
			oStmt = con.createStatement();
			oRs = oStmt.executeQuery("SELECT * FROM companyDetail WHERE deleteFlag = 0");
			while(oRs.next()) {
				jsonObj = new JSONObject();
				jsonObj.put("id", oRs.getInt("id")) ;
				jsonObj.put("tradeType",oRs.getString("tradeType"));
				jsonObj.put("companyName",oRs.getString("companyName"));			
				oJsonArray.put(jsonObj);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}
	
	public boolean addCompanyCategory(String strCategory) {
		boolean bFlag = true;
		PreparedStatement oPrStmt = null;
		try {
			JSONObject product = new JSONObject(strCategory);
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("INSERT INTO companyDetail(companyName,tradeType) values(?,?)");
			oPrStmt.setString(1, product.getString("companyName"));
			oPrStmt.setString(2, product.getString("tradeType"));
			oPrStmt.executeUpdate();
			
		}catch(Exception ex) {
			bFlag = false;
			ex.printStackTrace();
		}
		return bFlag;
	}
}
