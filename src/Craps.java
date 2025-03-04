import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        // Scanner + random number gen
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Variable declaration
        String playAgain, userInput;
        int die1, die2, sum, point;
        boolean pointCheck;

        // Main game loop
        do {
            // Initial roll and calculate sum
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            sum = die1 + die2;

            // Print out initial results
            System.out.println("\nInitial roll: " + die1 + " and " + die2 + ", Sum = " + sum);

            // Check roll conditions
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            }  else {
                // Establish the point
                point = sum;

                // Indicate the point to user
                System.out.println("The point is now: " + point);
                System.out.println("Keep rolling until you make the point or roll a 7.");

                // Set pointCheck to false
                pointCheck = false;

                // While the pointCheck is false
                while (!pointCheck) {
                    // Require the user to enter 'x' to roll
                    do {
                        System.out.print("\nEnter 'x' to roll again: ");
                        // Remove whitespace and ensure input is lowercase
                        userInput = in.nextLine().trim().toLowerCase();

                        // Check the input
                        if (!userInput.equals("x")) {
                            System.out.println("Please enter 'x' to roll.");
                        }
                    } while (!userInput.equals("x"));

                    // New roll and sum
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    // Print out new results
                    System.out.println("\nCurrent Roll: " + die1 + " and " + die2 + ", Sum = " + sum);

                    // Check if point is matched
                    if (sum == point) {
                        System.out.println("You made the point and won.");
                        pointCheck = true;
                    } else if (sum == 7) {
                        System.out.println("You got a 7! You lost.");
                        pointCheck = true;
                    } else {
                        System.out.println("Trying for the point: " + point);
                    }
                }
            }

            // Ask to play again
            do {
                System.out.print("\nDo you want to play again? (y/n): ");
                playAgain = in.nextLine();

                // Check to validate input
                if (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n")) {
                    System.out.println("Invalid choice, please enter 'y' or 'n'.");
                }
            } while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"));

        } while (playAgain.equalsIgnoreCase("y"));
    }
}