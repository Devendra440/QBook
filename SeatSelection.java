import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeatSelection {

    Scanner sc = new Scanner(System.in);

    /*
     * Seat status:
     *
     * 0 = Available
     * 1 = Booked
     * 2 = Selected
     */


    /*
     * Stores separate seat maps for every show.
     *
     * Each movie + date + theatre + screen + show
     * has its own seat map.
     */

    static Map<String, Map<String, Integer>> movieSeats =
            new HashMap<>();


    /*
     * Seats belonging to the current show.
     */

    Map<String, Integer> seats;


    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    public SeatSelection(
            Movie movie,
            String date,
            String theatre,
            String screen,
            String showTime) {

        /*
         * Create a unique key for the show.
         */

        String showKey =
                movie.getMovieName() + "_" +
                date + "_" +
                theatre + "_" +
                screen + "_" +
                showTime;


        /*
         * If this show was already opened before,
         * use its existing seat map.
         */

        if (movieSeats.containsKey(showKey)) {

            seats = movieSeats.get(showKey);

        }


        /*
         * If this is a new show,
         * create a new seat map.
         */

        else {

            seats = new HashMap<>();

            initializeAllSeatsAsAvailable();

            movieSeats.put(showKey, seats);
        }
    }


    // ==================================================
    // INITIALIZE SEATS
    // ==================================================

    private void initializeAllSeatsAsAvailable() {

        createSeats('A', 6);
        createSeats('B', 6);
        createSeats('C', 6);
        createSeats('D', 6);
        createSeats('E', 8);
        createSeats('F', 8);
    }


    // Create seats for a row

    private void createSeats(
            char row,
            int numberOfSeats) {

        for (int i = 1;
             i <= numberOfSeats;
             i++) {

            String seatName =
                    "" + row + i;

            /*
             * 0 = Available
             */

            seats.put(seatName, 0);
        }
    }


    // ==================================================
    // SEAT SELECTION SCREEN
    // ==================================================

    public void selectSeats(
            Movie movie,
            String date,
            String theatre,
            String screen,
            String showTime,
            double ticketPrice) {


        System.out.println();

        System.out.println(
                "===================================================="
        );

        System.out.println(
                "                  SEAT SELECTION"
        );

        System.out.println(
                "===================================================="
        );


        System.out.println(
                "Movie   : " + movie.getMovieName()
        );

        System.out.println(
                "Theatre : " + theatre
        );

        System.out.println(
                "Screen  : " + screen
        );

        System.out.println(
                "Date    : " + date
        );

        System.out.println(
                "Time    : " + showTime
        );

        System.out.println(
                "Price   : ₹" + ticketPrice + " per seat"
        );


        /*
         * Display seats only once.
         */

        displaySeats();


        System.out.println();

        System.out.println(
                "O = Available    X = Booked    S = Selected"
        );


        /*
         * Menu
         */

        while (true) {

            System.out.println();

            System.out.println(
                    "1. Select Seat(s)"
            );

            System.out.println(
                    "2. Remove Selected Seat"
            );

            System.out.println(
                    "3. Confirm Seats"
            );

            System.out.println(
                    "4. Back"
            );


            System.out.print(
                    "Enter choice: "
            );

            int choice = sc.nextInt();


            switch (choice) {


                // --------------------------------------
                // SELECT SEATS
                // --------------------------------------

                case 1:

                    selectSeat();

                    break;


                // --------------------------------------
                // REMOVE SEATS
                // --------------------------------------

                case 2:

                    removeSeat();

                    break;


                // --------------------------------------
                // CONFIRM SEATS
                // --------------------------------------

                case 3:

                    if (hasSelectedSeats()) {

                        System.out.println();

                        System.out.println(
                                "Select Payment Method"
                        );

                        System.out.println(
                                "1. UPI"
                        );

                        System.out.println(
                                "2. Credit Card"
                        );


                        System.out.print(
                                "Enter choice: "
                        );

                        int paymentChoice =
                                sc.nextInt();


                        Payment payment = null;


                        switch (paymentChoice) {


                            case 1:

                                payment =
                                        new UPIPayment(
                                                movie,
                                                date,
                                                theatre,
                                                screen,
                                                showTime,
                                                seats,
                                                ticketPrice
                                        );

                                break;


                            case 2:

                                payment =
                                        new CreditCardPayment(
                                                movie,
                                                date,
                                                theatre,
                                                screen,
                                                showTime,
                                                seats,
                                                ticketPrice
                                        );

                                break;


                            default:

                                System.out.println(
                                        "Invalid payment method."
                                );

                                continue;
                        }


                        /*
                         * Polymorphism:
                         *
                         * Payment reference can hold
                         * either UPIPayment or CreditCardPayment.
                         */

                        payment.makePayment();

                        return;


                    } else {

                        System.out.println();

                        System.out.println(
                                "Please select at least one seat."
                        );
                    }

                    break;


                // --------------------------------------
                // BACK
                // --------------------------------------

                case 4:

                    /*
                     * User did not complete booking.
                     *
                     * Selected seats become available again.
                     */

                    resetSelectedSeats();

                    return;


                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ==================================================
    // DISPLAY SEATS
    // ==================================================

    void displaySeats() {

        System.out.println();

        System.out.println(
                "                        SCREEN"
        );

        System.out.println(
                "               -----------------------"
        );

        System.out.println();


        /*
         * Rows A and B
         */

        displayRow('A', 6);

        displayRow('B', 6);


        /*
         * Rows C and D have aisle
         */

        displayRowWithAisle('C', 6);

        displayRowWithAisle('D', 6);


        /*
         * Rows E and F
         */

        displayRow('E', 8);

        displayRow('F', 8);


        System.out.println();

        System.out.println(
                "               -----------------------"
        );
    }


    // ==================================================
    // NORMAL ROW
    // ==================================================

    void displayRow(
            char row,
            int numberOfSeats) {


        /*
         * Display seat names
         */

        System.out.print(
                "               "
        );


        for (int i = 1;
             i <= numberOfSeats;
             i++) {

            String seatName =
                    "" + row + i;


            /*
             * %-4s gives spacing between seats.
             */

            System.out.printf(
                    "%-4s",
                    seatName
            );
        }


        System.out.println();


        /*
         * Display seat status
         */

        System.out.print(
                "               "
        );


        for (int i = 1;
             i <= numberOfSeats;
             i++) {

            String seatName =
                    "" + row + i;


            System.out.printf(
                    "%-4s",
                    getSeatSymbol(seatName)
            );
        }


        System.out.println();

        System.out.println();
    }


    // ==================================================
    // ROW WITH AISLE
    // ==================================================

    void displayRowWithAisle(
            char row,
            int numberOfSeats) {


        /*
         * Left side seats
         */

        System.out.print(
                "               "
        );


        for (int i = 1; i <= 3; i++) {

            String seatName =
                    "" + row + i;


            System.out.printf(
                    "%-4s",
                    seatName
            );
        }


        /*
         * Middle aisle
         */

        System.out.print(
                "      "
        );


        /*
         * Right side seats
         */

        for (int i = 4;
             i <= numberOfSeats;
             i++) {

            String seatName =
                    "" + row + i;


            System.out.printf(
                    "%-4s",
                    seatName
            );
        }


        System.out.println();


        /*
         * Display seat status
         */

        System.out.print(
                "               "
        );


        /*
         * Left side status
         */

        for (int i = 1; i <= 3; i++) {

            String seatName =
                    "" + row + i;


            System.out.printf(
                    "%-4s",
                    getSeatSymbol(seatName)
            );
        }


        /*
         * Middle aisle
         */

        System.out.print(
                "      "
        );


        /*
         * Right side status
         */

        for (int i = 4;
             i <= numberOfSeats;
             i++) {

            String seatName =
                    "" + row + i;


            System.out.printf(
                    "%-4s",
                    getSeatSymbol(seatName)
            );
        }


        System.out.println();

        System.out.println();
    }


    // ==================================================
    // GET SEAT SYMBOL
    // ==================================================

    String getSeatSymbol(
            String seatName) {


        int status =
                seats.get(seatName);


        if (status == 0) {

            return "O";
        }


        if (status == 1) {

            return "X";
        }


        return "S";
    }


    // ==================================================
    // SELECT SEATS
    // ==================================================

    void selectSeat() {

        System.out.println();


        while (true) {

            System.out.print(
                    "Enter seat number " +
                    "(Example A3, or 0 to stop): "
            );


            String input =
                    sc.next().toUpperCase();


            /*
             * 0 means stop selecting seats.
             */

            if (input.equals("0")) {

                break;
            }


            /*
             * Check whether seat exists.
             */

            if (!seats.containsKey(input)) {

                System.out.println(
                        "Seat " + input +
                        " does not exist."
                );

                continue;
            }


            int status =
                    seats.get(input);


            /*
             * Already booked
             */

            if (status == 1) {

                System.out.println(
                        "Seat " + input +
                        " is already booked."
                );
            }


            /*
             * Already selected
             */

            else if (status == 2) {

                System.out.println(
                        "Seat " + input +
                        " is already selected."
                );
            }


            /*
             * Available seat
             */

            else {

                seats.put(input, 2);

                System.out.println(
                        "Seat " + input +
                        " selected successfully."
                );
            }
        }
    }


    // ==================================================
    // REMOVE SEATS
    // ==================================================

    void removeSeat() {

        System.out.println();


        while (true) {

            System.out.print(
                    "Enter selected seat to remove " +
                    "(Example A3, or 0 to stop): "
            );


            String input =
                    sc.next().toUpperCase();


            /*
             * Stop removing seats.
             */

            if (input.equals("0")) {

                break;
            }


            /*
             * Check seat exists.
             */

            if (!seats.containsKey(input)) {

                System.out.println(
                        "Seat " + input +
                        " does not exist."
                );

                continue;
            }


            int status =
                    seats.get(input);


            /*
             * Seat is not selected.
             */

            if (status != 2) {

                System.out.println(
                        "Seat " + input +
                        " is not selected."
                );
            }


            /*
             * Remove selected seat.
             */

            else {

                seats.put(input, 0);

                System.out.println(
                        "Seat " + input +
                        " removed successfully."
                );
            }
        }
    }


    // ==================================================
    // RESET SELECTED SEATS
    // ==================================================

    void resetSelectedSeats() {

        for (Map.Entry<String, Integer> entry :
                seats.entrySet()) {

            if (entry.getValue() == 2) {

                /*
                 * S -> O
                 */

                entry.setValue(0);
            }
        }
    }


    // ==================================================
    // CHECK SELECTED SEATS
    // ==================================================

    boolean hasSelectedSeats() {

        for (int status :
                seats.values()) {

            if (status == 2) {

                return true;
            }
        }


        return false;
    }


    // ==================================================
    // GET CURRENT SEATS
    // ==================================================

    public Map<String, Integer> getSeats() {

        return seats;
    }
}