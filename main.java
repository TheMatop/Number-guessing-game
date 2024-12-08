import java.util.Random;
import java.util.Scanner;

// Define an enum to handle difficulty levels
enum Difficulty {
    EASY, MEDIUM, HARD
}

public class main {
    public static void main(String[] args) {
        boolean run = true;
        int maxGuesses = 0;
        int chosenNumber;
        Random rand = new Random();

        System.out.println("Welcome to my Java guessing game!");
        System.out.println("Please choose the difficulty level: \n1. Easy (10 chances) \n2. Medium (5 chances) \n3. Hard (3 chances)");

        // Set up variables
        Scanner scanner = new Scanner(System.in);

        // Start up the game
        String difficultyInput = scanner.nextLine().trim().toUpperCase();
        Difficulty difficulty = null;

        try {
            // Parse the input to match Difficulty enum
            switch (difficultyInput) {
                case "1":
                    difficulty = Difficulty.EASY;
                    break;
                case "2":
                    difficulty = Difficulty.MEDIUM;
                    break;
                case "3":
                    difficulty = Difficulty.HARD;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid difficulty choice. Please restart the game and select 1, 2, or 3.");
            return;
        }

        switch (difficulty) {
            case EASY:
                System.out.println("You have 10 guesses.");
                maxGuesses = 10;
                break;
            case MEDIUM:
                System.out.println("You have 5 guesses.");
                maxGuesses = 5;
                break;
            case HARD:
                System.out.println("You have 3 guesses.");
                maxGuesses = 3;
                break;
        }

        chosenNumber = rand.nextInt(100) + 1; // Random number between 1 and 100

        System.out.println("The computer is thinking about a number between 1 and 100. Guess the number!");

        int attempts = 0;

        while (run && attempts < maxGuesses) {
            System.out.println("Enter your guess:");
            int userGuess;

            try {
                userGuess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            attempts++;

            if (userGuess == chosenNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                run = false;
            } else if (userGuess > chosenNumber) {
                System.out.println("The number is smaller than " + userGuess + ".");
            } else {
                System.out.println("The number is greater than " + userGuess + ".");
            }

            if (attempts == maxGuesses && run) {
                System.out.println("Sorry! You've used all your guesses. The correct number was " + chosenNumber + ".");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
