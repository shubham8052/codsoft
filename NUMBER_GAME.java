import java.util.Random;
import java.util.Scanner;

public class NUMBER_GAME {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 10;
        
        int roundsWon = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + MIN + " and " + MAX + ":");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number correctly.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess + ".");
            }

            roundsWon += guessedCorrectly ? 1 : 0;

            System.out.println("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Game Over! You won " + roundsWon + " rounds.");
        scanner.close();
    }
}
