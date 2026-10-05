import java.util.Scanner;

public class UserLogin {

    Scanner sc = new Scanner(System.in);

    void loginUser() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("           USER LOGIN");
        System.out.println("=================================");

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        boolean loginSuccess = false;

        for (User user : UserRegistration.users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                loginSuccess = true;
                break;
            }
        }

        if (loginSuccess) {

            System.out.println();
            System.out.println("Login Successful!");

            MovieList movieList = new MovieList();
            movieList.displayMovies();

        } else {

            System.out.println();
            System.out.println("Invalid Username or Password.");
        }
    }
}