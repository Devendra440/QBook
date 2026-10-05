
import java.util.Scanner;

public class MovieList {

    Scanner sc = new Scanner(System.in);

    Movie[] movies = {

        new Movie(
                1,
                "Pushpa 2",
                "Telugu",
                "Action",
                "3h 20m",
                4.5,
                "An action drama movie."
        ),

        new Movie(
                2,
                "Kalki 2898 AD",
                "Telugu",
                "Sci-Fi",
                "3h",
                4.6,
                "A futuristic science fiction movie."
        ),

        new Movie(
                3,
                "Devara",
                "Telugu",
                "Action",
                "2h 50m",
                4.2,
                "An action drama movie."
        )
    };

    void displayMovies() {

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("        AVAILABLE MOVIES");
            System.out.println("=================================");

            for (Movie movie : movies) {

                System.out.println(
                        movie.getMovieId() + ". "
                        + movie.getMovieName()
                );
            }

            System.out.println("0. Back");

            System.out.print("Select Movie: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                return;
            }

            if (choice >= 1 && choice <= movies.length) {

                Movie selectedMovie = movies[choice - 1];

                MovieDetails details = new MovieDetails();
                details.displayDetails(selectedMovie);

            } else {

                System.out.println("Invalid choice.");
            }
        }
    }
}