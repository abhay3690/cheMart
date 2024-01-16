package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.DBConnection;

public class Checkout {
	public String getContact() {
		JSONObject jsonObj = null;
		JSONArray oJsonArray= new JSONArray();
		ResultSet oRs = null;
		Statement oStmt = null;
		try {
			Connection con = DBConnection.getConnection();
			oStmt = con.createStatement();
			oRs = oStmt.executeQuery("SELECT * FROM bill WHERE deleteFlag = 0");
			while(oRs.next()) {
				jsonObj = new JSONObject();
				jsonObj.put("id", oRs.getInt("id")) ;
				jsonObj.put("firstname",oRs.getString("firstname"));
				jsonObj.put("lastname",oRs.getDouble("lastname"));
				jsonObj.put("companyname",oRs.getDouble("companyname"));
				jsonObj.put("country",oRs.getString("country"));
				jsonObj.put("city",oRs.getString("city"));
				jsonObj.put("address",oRs.getDouble("address"));
				jsonObj.put("ordernote",oRs.getDouble("ordernote"));
				oJsonArray.put(jsonObj);
						}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return String.valueOf(oJsonArray);
	}
	public String checkout (String strCheckout) {
		JSONObject returnJson = new JSONObject();
		PreparedStatement oPrStmt = null;
		try {
			JSONObject checkout = new JSONObject(strCheckout);
			Connection con = DBConnection.getConnection();
			oPrStmt = con.prepareStatement("INSERT INTO bill(firstname,lastname,companyname,country,city,address,oredernote) values(?,?,?,?,?,?,?)");
			oPrStmt.setString(1,checkout.getString("firstname"));
			oPrStmt.setString(2, checkout.getString("lastname"));
			oPrStmt.setString(3, checkout.getString("companyname"));
			oPrStmt.setString(4, checkout.getString("country"));
			oPrStmt.setString(5, checkout.getString("city"));
			oPrStmt.setString(6, checkout.getString("address"));
			oPrStmt.setString(7, checkout.getString("ordernote"));
			oPrStmt.executeUpdate();
			returnJson.put("status","success");
		}catch(Exception ex) {
			returnJson.put("status","failed");
			
			ex.printStackTrace();
		}
		return returnJson.toString();
	}

}
