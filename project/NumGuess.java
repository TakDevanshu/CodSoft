import java.util.Scanner;

public class NumGuess {

    public static void main(String[] args) {

        int num = (int) (Math.random() * 100) + 1;

        try (Scanner sc = new Scanner(System.in)) {
            int tries = 0;

            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                System.out.println("Lets see if you can guess a correct number between 1 and 100: ");
                int guess = sc.nextInt();
                tries++;
                if (guess == num) {
                    guessedCorrectly = true;
                }
                else if (guess < num) {
                    System.out.println("Your guess is too low.");
                }
                else {
                    System.out.println("Your guess is too high.");
                }
            }

            // The user guessed correctly
            System.out.println("Congratulations! You guessed the correct number in " + tries + " guesses.");
        }
    }
}