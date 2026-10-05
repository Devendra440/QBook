import java.util.Map;
import java.util.Scanner;

public class BookingCancellation {

    Scanner sc = new Scanner(System.in);

    void cancelBooking(
            String bookingId,
            String selectedSeats,
            double totalAmount,
            Map<String, Integer> seats) {

        System.out.println();
        System.out.println("================================================");
        System.out.println("             CANCEL BOOKING");
        System.out.println("================================================");

        System.out.println("Booking ID   : " + bookingId);
        System.out.println("Seats        : " + selectedSeats);
        System.out.println("Amount Paid  : Rs" + totalAmount);

        System.out.println();
        System.out.println("Are you sure you want to cancel this booking?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            // Change booked seats X -> O
            String[] seatList = selectedSeats.split(", ");

            for (String seat : seatList) {

                if (seats.containsKey(seat)) {
                    seats.put(seat, 0);
                }
            }

            System.out.println();
            System.out.println("Booking cancelled successfully!");
            System.out.println("Refund Amount : Rs" + totalAmount);
            System.out.println("Refund Status : REFUND INITIATED");

        } else if (choice == 2) {

            System.out.println();
            System.out.println("Booking cancellation stopped.");

        } else {

            System.out.println();
            System.out.println("Invalid choice.");
        }
    }
}