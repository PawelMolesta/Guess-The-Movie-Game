import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;

public class MovieGame {

    private int guesses = 0;
    private int loops = 0;
    private Boolean hasWon = false;

    public void Start (String selectedMovie) {
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";
        String conversionChar = selectedMovie;


        System.out.println("GUESS THE MOVIE:");

        char[] wrongChar = {':', ' '};
        conversionChar = conversionChar.replace(":", "_");
        conversionChar = conversionChar.replace(" ", "_");
        conversionChar = conversionChar.replace(";", "_");
        conversionChar = conversionChar.replace(",", "_");


        Scanner scanner = new Scanner(System.in);

        for(int i = 10; i > 0; i--) {
            System.out.println("You are guessing : " + hidden);
            System.out.println("You have " + i + " guess/es left.");
            System.out.println("Guess a letter: ");

            String guess = scanner.nextLine();
            char currentChar = guess.charAt(0);

            if(Pattern.matches("[a-zA-Z]+", guess)) {
                for (int j = 1; j <= loops; j++) {
                    if (currentChar == lettersGuessed.charAt(j - 1)) {
                        System.out.println("You already guessed the letter " + currentChar);
                        i++;
                        guesses++;
                        hasWon = true;
                        break;
                    } else {
                        hasWon = false;
                    }


                }
                if (!hasWon) {

                    for (int r = 0; r <= selectedMovie.length() - 1; r++) {
                        char current = selectedMovie.charAt(r);

                        //Convert answer to lowercase
                        currentChar = Character.toLowerCase(currentChar);
                        if (current == currentChar) {
                            System.out.println("Your guess is correct.");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }

                        //Convert answer to uppercase
                        currentChar = Character.toUpperCase(currentChar);
                        if (current == currentChar) {
                            System.out.println("Your guess is correct.");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }


                    }
                    lettersGuessed = lettersGuessed + currentChar + ", ";
                    guesses++;
                    loops++;
                }

                if (conversionChar.equals(hidden)) {
                    System.out.println("YOU WIN!");
                    System.out.println("The movie was " + selectedMovie);
                    break;
                }
            } else {
                System.out.println("Please enter an alphabetical character.");
                i++;
            }
        }

        if (!conversionChar.equals(hidden)) {
            System.out.println("DEFEAT!");

        }



    }
}












