package part2_collection;

// Part 2.1 Custom class - movie
public class Movie {
    private String title;
    private String director;
    private String genre;
    private int year;
    private double rating;

    public Movie(String title, String director, String genre, int year, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public double getRating() { return rating; }

    // full info
    public String toDetailedString() {
        return "Title:    " + title + "\n"
             + "Director: " + director + "\n"
             + "Genre:    " + genre + "\n"
             + "Year:     " + year + "\n"
             + "Rating:   " + rating;
    }

    // one line
    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "%-28s | %-20s | %-10s | %d | %.1f",
                title, director, genre, year, rating);
    }
}
