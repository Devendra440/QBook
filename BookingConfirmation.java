import java.util.Map;
import java.util.Scanner;

public class BookingConfirmation {

    Scanner sc = new Scanner(System.in);
    private static int bookingCounter = 1001; // Counter replacing Random

   void showConfirmation(
        Movie movie,
        String date,
        String theatre,
        String screen,
        String showTime,
	Map<String, Integer> seats,
        String selectedSeats,
        int numberOfTickets,
        double totalAmount,
        String paymentMethod) {

        // Incremental Booking ID without using Random
        String bookingId = "BK" + (bookingCounter++);

        while (true) {
            System.out.println();
            System.out.println("================================================");
            System.out.println("            BOOKING CONFIRMATION");
            System.out.println("================================================");

            System.out.println("Booking ID     : " + bookingId);
            System.out.println("Movie          : " + movie.getMovieName());
            System.out.println("Theatre        : " + theatre);
            System.out.println("Screen         : " + screen);
            System.out.println("Date           : " + date);
            System.out.println("Show Time      : " + showTime);
            System.out.println("Seats          : " + selectedSeats);
            System.out.println("No. of Tickets : " + numberOfTickets);
            System.out.println("Total Amount   : Rs" + totalAmount);
            System.out.println("Payment Method : " + paymentMethod);
            System.out.println("Status         : CONFIRMED");

            System.out.println("================================================");
            System.out.println("            Enjoy Your Movie!");
            System.out.println("================================================");

            System.out.println();
            System.out.println("1. View Ticket Again");
	    System.out.println("2. Cancel Booking");
	    System.out.println("3. Back to Main Menu");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Loops and displays ticket again
                    break;
		 case 2:

        		BookingCancellation cancellation =
                	new BookingCancellation();

        		cancellation.cancelBooking(
                		bookingId,
                		selectedSeats,
                		totalAmount,
                		seats
        		);

        		return;
                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}