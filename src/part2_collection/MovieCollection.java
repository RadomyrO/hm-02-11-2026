package part2_collection;

// Part 2.1 Collection class
public class MovieCollection {
    private int count;       // num of movies
    private Movie[] movies;  // storage

    public MovieCollection() {
        movies = new Movie[4];
        count = 0;
    }

    public int getCount() { return count; }

    // Part 2.1.3 add
    public void add(Movie newMovie) {
        // full -> grow x2
        if (count == movies.length) {
            Movie[] bigger = new Movie[movies.length * 2];
            for (int i = 0; i < count; i++) {
                bigger[i] = movies[i];
            }
            movies = bigger;
        }
        movies[count++] = newMovie;
    }

    // Part 2.1.4 printOne
    public void printOne(int i) {
        if (i < 0 || i >= count) {
            System.out.println("No movie with index " + i);
            return;
        }
        System.out.println("--- Movie #" + (i + 1) + " ---");
        System.out.println(movies[i].toDetailedString());
    }

    // Part 2.1.4 print all
    public void print() {
        if (count == 0) {
            System.out.println("Collection is empty");
            return;
        }
        printHeader();
        for (int i = 0; i < count; i++) {
            System.out.printf("%2d. %s%n", i + 1, movies[i]);
        }
    }

    private void printHeader() {
        System.out.println(String.format("    %-28s | %-20s | %-10s | %s | %s",
                "Title", "Director", "Genre", "Year", "Rating"));
        System.out.println("-".repeat(80));
    }

    // Part 2.1.5 find by title (part of it, ignore case)
    public void find(String s) {
        String key = s.toLowerCase();
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (movies[i].getTitle().toLowerCase().contains(key)) {
                printOne(i);
                found++;
            }
        }
        if (found == 0) System.out.println("Nothing found for \"" + s + "\"");
    }

    // Part 2.1.6 bubble sort by rating (high -> low)
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < count - 1 - i; j++) {
                if (movies[j].getRating() < movies[j + 1].getRating()) {
                    Movie tmp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
    }

    // Part 2.1.7 find by year range
    public void findByYear(int from, int to) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            int y = movies[i].getYear();
            if (y >= from && y <= to) {
                if (found == 0) printHeader();
                System.out.printf("%2d. %s%n", i + 1, movies[i]);
                found++;
            }
        }
        if (found == 0) System.out.println("No movies in " + from + "-" + to);
    }

    // Part 2.1.7 find by genre + min year (both at once)
    public void findByGenreAndYear(String genre, int minYear) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            Movie m = movies[i];
            if (m.getGenre().equalsIgnoreCase(genre) && m.getYear() >= minYear) {
                if (found == 0) printHeader();
                System.out.printf("%2d. %s%n", i + 1, m);
                found++;
            }
        }
        if (found == 0) System.out.println("Nothing found");
    }
}
