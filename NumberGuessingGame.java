package com.NumberGuessingGame;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\n--- Round " + rounds + " ---");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber +
                                       " correctly in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    guessedCorrectly = true;
                    break;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        scanner.close();
        System.out.println("\nGame Over. You played " + rounds + " round(s) and took a total of " + totalAttempts + " attempts.");
    }
}


