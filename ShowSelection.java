import java.util.Scanner;

public class ShowSelection {

    Scanner sc = new Scanner(System.in);

    double getTicketPrice(Movie movie, String theatre) {

    String movieName = movie.getMovieName();

    if (movieName.equals("Pushpa 2")) {

        if (theatre.equals("PVR Cinemas")) {
            return 250;
        } 
        else if (theatre.equals("INOX")) {
            return 220;
        } 
        else {
            return 180;
        }

    } 
    else if (movieName.equals("Kalki 2898 AD")) {

        if (theatre.equals("PVR Cinemas")) {
            return 280;
        } 
        else if (theatre.equals("INOX")) {
            return 250;
        } 
        else {
            return 200;
        }

    } 
    else if (movieName.equals("Devara")) {

        if (theatre.equals("PVR Cinemas")) {
            return 220;
        } 
        else if (theatre.equals("INOX")) {
            return 200;
        } 
        else {
            return 170;
        }
    }

    return 0;
}

    void selectShow(Movie movie) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("          SHOW SELECTION");
        System.out.println("=================================");

        System.out.println("Movie : " + movie.getMovieName());

        // ---------------- DATE ----------------

        System.out.println();
        System.out.println("Available Dates:");
        System.out.println("1. 15-08-2026");
        System.out.println("2. 16-08-2026");
        System.out.println("3. 17-08-2026");

        System.out.print("Select Date: ");
        int dateChoice = sc.nextInt();

        String selectedDate;

        switch (dateChoice) {

            case 1:
                selectedDate = "15-08-2026";
                break;

            case 2:
                selectedDate = "16-08-2026";
                break;

            case 3:
                selectedDate = "17-08-2026";
                break;

            default:
                System.out.println("Invalid date.");
                return;
        }

        // ---------------- THEATRE ----------------

        System.out.println();
        System.out.println("Available Theatres:");
        System.out.println("1. PVR Cinemas");
        System.out.println("2. INOX");
        System.out.println("3. CMR Cinemas");

        System.out.print("Select Theatre: ");
        int theatreChoice = sc.nextInt();

        String selectedTheatre;
	double ticketPrice;
        switch (theatreChoice) {

            case 1:
                selectedTheatre = "PVR Cinemas";
		ticketPrice = getTicketPrice(movie, selectedTheatre);
                break;

            case 2:
                selectedTheatre = "INOX";
		ticketPrice = getTicketPrice(movie, selectedTheatre);
                break;

            case 3:
                selectedTheatre = "CMR Cinemas";
		ticketPrice = getTicketPrice(movie, selectedTheatre);
                break;

            default:
                System.out.println("Invalid theatre.");
                return;
        }

        // ---------------- SCREEN ----------------

        System.out.println();
        System.out.println("Available Screens:");
        System.out.println("1. Screen 1");
        System.out.println("2. Screen 2");

        System.out.print("Select Screen: ");
        int screenChoice = sc.nextInt();

        String selectedScreen;

        switch (screenChoice) {

            case 1:
                selectedScreen = "Screen 1";
                break;

            case 2:
                selectedScreen = "Screen 2";
                break;

            default:
                System.out.println("Invalid screen.");
                return;
        }

        // ---------------- SHOW TIME ----------------

        System.out.println();
        System.out.println("Available Show Times:");
        System.out.println("1. 10:00 AM");
        System.out.println("2. 02:00 PM");
        System.out.println("3. 06:00 PM");
        System.out.println("4. 10:00 PM");

        System.out.print("Select Show Time: ");
        int timeChoice = sc.nextInt();

        String selectedTime;

        switch (timeChoice) {

            case 1:
                selectedTime = "10:00 AM";
                break;

            case 2:
                selectedTime = "02:00 PM";
                break;

            case 3:
                selectedTime = "06:00 PM";
                break;

            case 4:
                selectedTime = "10:00 PM";
                break;

            default:
                System.out.println("Invalid show time.");
                return;
        }

        // ---------------- SHOW SUMMARY ----------------

        System.out.println();
        System.out.println("=================================");
        System.out.println("          SELECTED SHOW");
        System.out.println("=================================");

        System.out.println("Movie   : " + movie.getMovieName());
        System.out.println("Date    : " + selectedDate);
        System.out.println("Theatre : " + selectedTheatre);
        System.out.println("Screen  : " + selectedScreen);
        System.out.println("Time    : " + selectedTime);
	System.out.println("Price   : Rs" + ticketPrice + " per seat");
        System.out.println();
        System.out.println("1. Continue to Seat Selection");
        System.out.println("2. Back");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            SeatSelection seatSelection =
        	new SeatSelection(
                	movie,
                	selectedDate,
                	selectedTheatre,
                	selectedScreen,
                	selectedTime
        		);

            seatSelection.selectSeats(
                    movie,
                    selectedDate,
                    selectedTheatre,
                    selectedScreen,
                    selectedTime,
                    ticketPrice
            );

        } else if (choice == 2) {

            return;

        } else {

            System.out.println("Invalid choice.");
        }
    }
}