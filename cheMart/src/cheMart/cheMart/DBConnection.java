package cheMart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;
		try{  
			 //new Driver();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eSchool","root","Abhay@3690");
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Not able find required Driver!");
		}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return con;
	}
}
