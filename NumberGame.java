import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int answer, guess;
        final int max = 100;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;
        int guessCount = 0;

        while (playAgain) {
            answer = rand.nextInt(max) + 1;
            System.out.println("Guess a number between 1 and 100");
            guessCount = 0;

            while (true) {
                guess = sc.nextInt();
                guessCount++;
                if (guess == answer) {
                    System.out.println("You Guessed it right, the number was " + answer);
                    System.out.println("You took " + guessCount + " guesses.");
                    break;
                } else if (guess < answer) {
                    System.out.println("Increase the number and try again.");
                } else {
                    System.out.println("Decrease the number and try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = sc.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
    }
}
