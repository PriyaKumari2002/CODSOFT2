import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome Player to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;

            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + roundsPlayed + ":");
            System.out.println(" Player select a number between 1 and 100.");
            System.out.println(" You have " + maxAttempts + " attempts to guess it.");


            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess Player: ");
                int userGuess;

                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                    scanner.next();
                    continue;
                }

                attemptsUsed++;


                if (userGuess == targetNumber) {
                    System.out.println("Congratulation Player! You guessed the correct number in " + attemptsUsed + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total rounds won: " + score);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
