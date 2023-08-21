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
				jsonObj.put("companyName",oRs.getString("companyName"));
				jsonObj.put("quantity",oRs.getInt("quantity"));			
				oJsonArray.put(jsonObj);
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}
	
	public boolean addProduct(String strProduct) {
		boolean bFlag = true;
		PreparedStatement oPrStmt = null;
		try {
			JSONObject product = new JSONObject(strProduct);
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("INSERT INTO product(name,price,companyId,shortDesc,longDesc) values(?,?,?,?,?)");
			oPrStmt.setString(1, product.getString("name"));
			oPrStmt.setDouble(2, product.getDouble("price"));
			oPrStmt.setInt(3, product.getInt("companyId"));
			oPrStmt.setString(4, product.getString("shortDesc"));
			oPrStmt.setString(5, product.getString("longDesc"));
			oPrStmt.executeUpdate();
			
		}catch(Exception ex) {
			bFlag = false;
			ex.printStackTrace();
		}
		return bFlag;
	}

}
