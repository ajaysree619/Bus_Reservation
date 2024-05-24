package Reservation_Project;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
	public static void main(String[] args)  {
		
		BusDataAccess busDataAccess=new BusDataAccess();
		try {
		busDataAccess.displayBusInfo();
		
		Scanner scanner=new Scanner(System.in);
		
		
		int userOpt=1;
		while(userOpt==1) {
			System.out.println("Enter 1 to Book and 2 to Exit...");
			userOpt=scanner.nextInt();
			if(userOpt==1) {
				Booking booking=new Booking();
				if(booking.isAvailable()) {
					BookingDataAccess bookingDataAccess=new BookingDataAccess();
					bookingDataAccess.addBooking(booking);
					System.out.println("Successfully Booked");
				}else {
					System.out.println("Sorry Bus is Full. Try Another Bus or Date.");
				}
			}
		}
		
		scanner.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
