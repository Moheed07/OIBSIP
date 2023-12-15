import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {

        // Initialize Scanner and Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game variables
        int maxTries = 1;
        int round = 1;
        int totalScore = 0;

        // Main game loop
        while (true) {

            // Generate random number for round
            System.out.println("Random" + round);
            int randomNumber = random.nextInt(100) + 1;

            // Reset tries counter for round
            int tries = 0;

            // Main user input loop for round
            int userGuess;

            while (true) {

                // Get user guess
                System.out.println("Enter your guess (1-100) or type 'exit' to quit: ");
                String input = scanner.nextLine();
                
                // Check for exit command
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("You have chosen to quit the game. ");
                    System.out.println("Your total score is: " +totalScore);
                    System.exit(0);
                }
                
                // Parse user guess and validate
                userGuess = Integer.parseInt(input);

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Invalid guess! Please enter a number between 1 and 100.");
                } else {
                    tries++;
                    int score = maxTries - tries;

                    // Check if number is correct
                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        System.out.println("Your score for this round is: " +score);
                        totalScore += score;
                        round++;
                        break;
                    } else if (userGuess < randomNumber) {
                        System.out.println("The correct number is higher than your guess. ");
                    } else {
                        System.out.println("The correct number is lower than your guess. ");
                    }

                    // Check if user has run out of attempts
                    if (tries >= maxTries) {
                        System.out.println("Sorry, you have run out of attempts!");
                        System.out.println("The correct number was: " +randomNumber);
                        round++;
                        break;
                    }
                }
            }

            // Check if user has completed all rounds
            if (round > 3) {
                System.out.println("You have completed all round!");
                System.out.println("Your total score is: " +totalScore);
                System.exit(0);
            }
        }
    }
}
