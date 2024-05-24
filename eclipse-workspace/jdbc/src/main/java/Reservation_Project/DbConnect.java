package Reservation_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	private static final String url="jdbc:mysql://localhost:3306/busrev";
	private static final String user="root";
	private static final String pass="root";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,pass);
	}

}
