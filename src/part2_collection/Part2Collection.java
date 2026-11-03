package part2_collection;

import java.util.Scanner;

// Part 2.2 Main - Option 1, user dialogue
public class Part2Collection {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MovieCollection movies = new MovieCollection();

        // few movies so list isnt empty at start
        movies.add(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8));
        movies.add(new Movie("The Godfather", "Francis Coppola", "Crime", 1972, 9.2));
        movies.add(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 8.7));

        System.out.println("Welcome to the movie database!");

        // main menu loop
        while (true) {
            System.out.println();
            System.out.println("Choose an option to proceed:");
            System.out.println("1 - add movies to collection");
            System.out.println("2 - print all movies");
            System.out.println("3 - print one movie by number");
            System.out.println("4 - sort movies by rating");
            System.out.println("5 - search movies");
            System.out.println("0 - exit the program");

            int opt = readInt("Your choice: ");
            switch (opt) {
                case 1 -> inputItems(movies);
                case 2 -> movies.print();
                case 3 -> movies.printOne(readInt("Movie number: ") - 1);
                case 4 -> sort(movies);
                case 5 -> search(movies);
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Wrong option, try again");
            }
        }
    }

    // Part 2.2 input sub-dialogue
    public static void inputItems(MovieCollection movies) {
        System.out.println("--- Adding movies (empty title = stop) ---");
        while (true) {
            String title = readLine("Title: ");
            if (title.isEmpty()) break; // stop input

            String director = readLine("Director: ");
            String genre = readLine("Genre: ");
            int year = readInt("Year: ");
            double rating = readDouble("Rating (0-10): ");

            movies.add(new Movie(title, director, genre, year, rating));
            System.out.println("Added! Total: " + movies.getCount());
        }
    }

    // Part 2.2 search sub-dialogue
    public static void search(MovieCollection movies) {
        System.out.println("Search by:");
        System.out.println("1 - title");
        System.out.println("2 - year range");
        System.out.println("3 - genre + min year");
        int opt = readInt("Your choice: ");

        switch (opt) {
            case 1 -> movies.find(readLine("Title (or part): "));
            case 2 -> {
                int from = readInt("Year from: ");
                int to = readInt("Year to: ");
                movies.findByYear(from, to);
            }
            case 3 -> {
                String genre = readLine("Genre: ");
                int minYear = readInt("Min year: ");
                movies.findByGenreAndYear(genre, minYear);
            }
            default -> System.out.println("Wrong option");
        }
    }

    // Part 2.2 sort sub-dialogue
    public static void sort(MovieCollection movies) {
        movies.sort();
        System.out.println("Sorted by rating (high -> low):");
        movies.print();
    }

    // helpers for safe input
    static String readLine(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    static int readInt(String msg) {
        while (true) {
            try {
                return Integer.parseInt(readLine(msg));
            } catch (NumberFormatException e) {
                System.out.println("Need a whole number!");
            }
        }
    }

    static double readDouble(String msg) {
        while (true) {
            try {
                return Double.parseDouble(readLine(msg).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Need a number!");
            }
        }
    }
}
