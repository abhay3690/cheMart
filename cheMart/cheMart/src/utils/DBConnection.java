package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Properties prop = ReadProperties.readPropertiesFile("/cheMart/conf/credentials.properties");
//		      System.out.println("username: "+ prop.getProperty("username"));
//		      System.out.println("password: "+ prop.getProperty("password"));
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cheMart","root","Abhay@3690");
		}catch (Exception e) {
			System.out.println("Not able find required Driver!");
		}
		return con;
	}
}
