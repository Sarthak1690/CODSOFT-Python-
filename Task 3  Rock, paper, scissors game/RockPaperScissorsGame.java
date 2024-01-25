import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            String computerChoice = generateComputerChoice();
            System.out.println("Computer's choice: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static String generateComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int randomIndex = new Random().nextInt(choices.length);
        return choices[randomIndex];
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "Congratulations! You win!";
        } else {
            return "Sorry, you lose. Try again!";
        }
    }
}
