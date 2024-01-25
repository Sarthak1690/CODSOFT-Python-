import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
            }

        } while (userGuess != targetNumber);

        scanner.close();
    }
}
