import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        //Declare global variables
        String movies = null;
        String selectedMovie = null;
        int movieNum = 0;
        int randomMovie = 0;

        //Initialize classes
        File moviesFile = new File("movies.txt");
        Scanner scanner = new Scanner(moviesFile);

        while(scanner.hasNextLine()) {
            String movieLine = scanner.nextLine();
            movies = movies + (movieLine + "\n");
            movieNum++;
        }

        //Test - print all movies
        //System.out.println(movies);

        //Test - print number of movies
        //System.out.println(movieNum);

        //Get random movie number based on movies.txt file
        randomMovie = (int) (Math.random() * movieNum);

        //Test - print random movie number
        //System.out.println(randomMovie);


        File moviesFile2 = new File("movies.txt");
        Scanner scanner2 = new Scanner(moviesFile2);

        int i = 0;
        while(i <= randomMovie) {
            selectedMovie = scanner2.nextLine();
            i++;
        }
        //Test - print random movie
        //System.out.println(selectedMovie);

        MovieGame movieGame = new MovieGame();
        movieGame.Start(selectedMovie);

    }
}
