package cheMart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eSchool","root","Parthiv@8960");
		}catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Not able find required Driver!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
