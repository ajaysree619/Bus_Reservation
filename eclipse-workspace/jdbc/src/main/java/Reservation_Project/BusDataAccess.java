package Reservation_Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BusDataAccess {
	
	public void displayBusInfo() throws SQLException {
		String query="Select * from bus";
		Connection connection=DbConnect.getConnection();
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==0) {
				System.out.println("AC : No");
			}else {
				System.out.println("AC : Yes");
			}
			System.out.println("Capacity: "+rs.getInt(3));
		}
		
		System.out.println("------------------------------");
	}
	
	public int getCapacity(int id) throws Exception{
		String query="Select capacity from bus where id="+id;
		Connection connection=DbConnect.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}

}
