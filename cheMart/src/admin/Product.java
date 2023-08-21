package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				jsonObj.put("name",oRs.getString("name"));
				jsonObj.put("price",oRs.getDouble("price"));
				jsonObj.put("companyId",oRs.getString("companyId"));
				jsonObj.put("shortDesc",oRs.getString("shortDesc"));
				jsonObj.put("longDesc", oRs.getString("longDesc"));
				oJsonArray.put(jsonObj);
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}
	
	public boolean isProductExists(String strProduct) {
		boolean bFlag = false;
		ResultSet oRs = null;
		PreparedStatement oPrStmt = null;
		try {
			JSONObject product = new JSONObject(strProduct);
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("SELECT id FROM product WHERE deleteFlag = 0 and companyId=? and name=?");
			oPrStmt.setInt(1, product.getInt("companyId"));
			oPrStmt.setString(2, product.getString("name"));
			oRs = oPrStmt.executeQuery();
			if(oRs.next()) {
				bFlag = true;
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return bFlag;
	}
	
	public String addProduct(String strProduct) {
		JSONObject returnJson = new JSONObject();
		PreparedStatement oPrStmt = null;
		try {
			boolean bFlag = isProductExists(strProduct);
			if(!bFlag) {
				JSONObject product = new JSONObject(strProduct);
				Connection con = DBConnection.getConnection();
				oPrStmt = con.prepareStatement("INSERT INTO product(name,price,companyId,shortDesc,longDesc) values(?,?,?,?,?)");
				oPrStmt.setString(1, product.getString("name"));
				oPrStmt.setDouble(2, product.getDouble("price"));
				oPrStmt.setInt(3, product.getInt("companyId"));
				oPrStmt.setString(4, product.getString("shortDesc"));
				oPrStmt.setString(5, product.getString("longDesc"));
				oPrStmt.executeUpdate();
				returnJson.put("status","success");
			}
			returnJson.put("status","exists");
		}catch(Exception ex) {
			returnJson.put("status","failed");
			ex.printStackTrace();
		}
		return returnJson.toString();
	}

}
