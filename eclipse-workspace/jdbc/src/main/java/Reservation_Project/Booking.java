package Reservation_Project;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	String passengerName;
	int busno;
	Date date;
	
	Booking() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Passenger Name :");
		passengerName=scanner.next(); 
		System.out.println("Enter Busno :");
		busno=scanner.nextInt();
		System.out.println("Enter Date dd-mm-yyyy");
		String dateInputString=scanner.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAvailable() throws Exception {
		
		BusDataAccess busDataAccess=new BusDataAccess();
		BookingDataAccess bookingDataAccess=new BookingDataAccess();
		
		int capacity=busDataAccess.getCapacity(busno);
		
		int booked=bookingDataAccess.getBookedCount(busno,date);	
		
		return booked<capacity;
	}
	

}
