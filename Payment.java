import java.util.Map;
import java.util.Scanner;

abstract class Payment {

    Scanner sc = new Scanner(System.in);

    Movie movie;
    String date;
    String theatre;
    String screen;
    String showTime;

    Map<String, Integer> seats;

    double ticketPrice;

    int numberOfTickets;
    String selectedSeats;
    double totalAmount;

    Payment(
            Movie movie,
            String date,
            String theatre,
            String screen,
            String showTime,
            Map<String, Integer> seats,
            double ticketPrice) {

        this.movie = movie;
        this.date = date;
        this.theatre = theatre;
        this.screen = screen;
        this.showTime = showTime;
        this.seats = seats;
        this.ticketPrice = ticketPrice;

        calculateAmount();
    }

    // Abstract method
    abstract boolean pay();

    // Calculate selected seats and amount
    void calculateAmount() {

        numberOfTickets = 0;
        selectedSeats = "";

        for (Map.Entry<String, Integer> entry : seats.entrySet()) {

            if (entry.getValue() == 2) {

                numberOfTickets++;

                if (selectedSeats.isEmpty()) {
                    selectedSeats = entry.getKey();
                } else {
                    selectedSeats =
                            selectedSeats + ", " + entry.getKey();
                }
            }
        }

        totalAmount = numberOfTickets * ticketPrice;
    }

    // Common payment process
    void makePayment() {

        System.out.println();
        System.out.println("================================================");
        System.out.println("              BOOKING DETAILS");
        System.out.println("================================================");

        System.out.println("Movie          : " + movie.getMovieName());
        System.out.println("Theatre        : " + theatre);
        System.out.println("Screen         : " + screen);
        System.out.println("Date           : " + date);
        System.out.println("Show Time      : " + showTime);
        System.out.println("Selected Seats : " + selectedSeats);
        System.out.println("No. of Tickets : " + numberOfTickets);
        System.out.println("Price / Ticket : Rs" + ticketPrice);
        System.out.println("Total Amount   : Rs" + totalAmount);

        System.out.println();
        System.out.println("1. Make Payment");
        System.out.println("2. Cancel Booking");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 2) {

            releaseSelectedSeats();

            System.out.println();
            System.out.println("Booking cancelled.");
            return;
        }

        if (choice != 1) {

            System.out.println("Invalid choice.");
            return;
        }

        // Call child class pay() method
        boolean paymentSuccessful = pay();

        if (paymentSuccessful) {

            // ONLY AFTER SUCCESSFUL PAYMENT
            confirmSeats();

            System.out.println();
            System.out.println("Payment successful!");

            BookingConfirmation confirmation =
                    new BookingConfirmation();

            confirmation.showConfirmation(
        		movie,
        		date,
        		theatre,
        		screen,
        		showTime,
        		seats,
        		selectedSeats,
        		numberOfTickets,
        		totalAmount,
        		getPaymentMethod()
			);

        } else {

            // Payment failed -> release seats
            releaseSelectedSeats();

            System.out.println();
            System.out.println("Payment failed.");
            System.out.println("Selected seats have been released.");
        }
    }

    // Each child class tells us its payment method
    abstract String getPaymentMethod();

    // S -> X
    void confirmSeats() {

        for (Map.Entry<String, Integer> entry : seats.entrySet()) {

            if (entry.getValue() == 2) {
                entry.setValue(1);
            }
        }
    }

    // S -> O
    void releaseSelectedSeats() {

        for (Map.Entry<String, Integer> entry : seats.entrySet()) {

            if (entry.getValue() == 2) {
                entry.setValue(0);
            }
        }
    }
}

class UPIPayment extends Payment {

    UPIPayment(
            Movie movie,
            String date,
            String theatre,
            String screen,
            String showTime,
            Map<String, Integer> seats,
            double ticketPrice) {

        super(movie, date, theatre, screen, showTime, seats, ticketPrice);
    }

    @Override
    boolean pay() {

        System.out.print("Enter UPI ID: ");
        String upiId = sc.next();

        System.out.print("Enter UPI PIN: ");
        String upiPin = sc.next();

        System.out.println();
        System.out.println("Processing UPI payment...");

        if (upiPin.length() >= 4) {
            return true;
        }

        return false;
    }

    @Override
    String getPaymentMethod() {
        return "UPI";
    }
}

class CreditCardPayment extends Payment {

    CreditCardPayment(
            Movie movie,
            String date,
            String theatre,
            String screen,
            String showTime,
            Map<String, Integer> seats,
            double ticketPrice) {

        super(movie, date, theatre, screen, showTime, seats, ticketPrice);
    }

    @Override
    boolean pay() {

        System.out.print("Enter Credit Card Number: ");
        long cardNumber = sc.nextLong();

        System.out.print("Enter Credit Card PIN: ");
        String pin = sc.next();

        System.out.println();
        System.out.println("Processing Credit Card payment...");

        if (pin.length() >= 4) {
            return true;
        }

        return false;
    }

    @Override
    String getPaymentMethod() {
        return "Credit Card";
    }
}