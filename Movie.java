public class Movie {

    private int movieId;
    private String movieName;
    private String language;
    private String genre;
    private String duration;
    private double rating;
    private String description;

    Movie(int movieId, String movieName, String language,
          String genre, String duration,
          double rating, String description) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
    }

    int getMovieId() {
        return movieId;
    }

    String getMovieName() {
        return movieName;
    }

    String getLanguage() {
        return language;
    }

    String getGenre() {
        return genre;
    }

    String getDuration() {
        return duration;
    }

    double getRating() {
        return rating;
    }

    String getDescription() {
        return description;
    }
}