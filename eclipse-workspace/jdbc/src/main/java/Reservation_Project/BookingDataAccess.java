package Reservation_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDataAccess {
	public int getBookedCount(int busno,Date date) throws SQLException {
		
		String query="Select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection connection=DbConnect.getConnection();
		PreparedStatement pst=connection.prepareStatement(query);
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		pst.setInt(1, busno);
		pst.setDate(2, sqlDate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking) throws SQLException {
		String query="Insert into booking values(?,?,?)";
		Connection connection=DbConnect.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
		PreparedStatement pst=connection.prepareStatement(query);
		
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busno);
		pst.setDate(3, sqlDate);
		
		pst.executeUpdate();
	}

}
