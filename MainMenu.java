import java.util.Scanner;

public class MainMenu {

    Scanner sc = new Scanner(System.in);

    void displayMenu() {

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("     MOVIE TICKET BOOKING");
            System.out.println("=================================");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    UserRegistration registration = new UserRegistration();
                    registration.registerUser();
                    break;

                case 2:
                    UserLogin login = new UserLogin();
                    login.loginUser();
                    break;

                case 3:
                    System.out.println("Thank you for using Movie Ticket Booking System!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}