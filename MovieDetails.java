import java.util.Scanner;

public class MovieDetails {

    Scanner sc = new Scanner(System.in);

    void displayDetails(Movie movie) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         MOVIE DETAILS");
        System.out.println("=================================");

        System.out.println("Movie Name : " + movie.getMovieName());
        System.out.println("Language   : " + movie.getLanguage());
        System.out.println("Genre      : " + movie.getGenre());
        System.out.println("Duration   : " + movie.getDuration());
        System.out.println("Rating     : " + movie.getRating());
        System.out.println("Description: " + movie.getDescription());

        System.out.println();
        System.out.println("1. Select Movie");
        System.out.println("2. Back to Movie List");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

           ShowSelection showSelection = new ShowSelection();

	   showSelection.selectShow(movie);

        } else if (choice == 2) {

            return;

        } else {

            System.out.println("Invalid choice.");
        }
    }
}