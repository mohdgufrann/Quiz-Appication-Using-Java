import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;  
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; 
            int attemptsLeft = 7;  
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100. You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                
                if (sc.hasNextInt()) {
                    userGuess = sc.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and 100.");
                    sc.next(); 
                    continue;
                }

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; 
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry! You are out of attempts. The correct number was " + numberToGuess);
            }

            System.out.println("Your current total score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("\n=== Game Over! Your Final Score: " + totalScore + " ===");
        sc.close();
    }
}

