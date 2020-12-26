import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    public static boolean invitationNewGame() {
        Scanner scanner = new Scanner(System.in);
        int userNumber;

        do {
            System.out.println("Want to play the game again?");
            System.out.println("1 - Yes.");
            System.out.println("0 - No.");
            userNumber = scanner.nextInt();
        } while (userNumber < 0 || userNumber > 1);

        return userNumber == 1;
    }

    static void guessNumber(int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the number.");
            userNumber = scanner.nextInt();

            if (userNumber == randomNumber) {
                System.out.println("You won!");
                break;
            } else if( userNumber > randomNumber) {
                System.out.println("Number more.");
            } else {
                System.out.println("Number less.");
            }

            if (i == 2) {
                System.out.println("You lost!");
            }
        }
    }

    public static void playGame() {
        Random random = new Random();
        int randomNumber;
        boolean newGame;

        do {
            randomNumber = random.nextInt(10);

            guessNumber(randomNumber);

            newGame = invitationNewGame();

            if (!newGame) {
                System.out.println("Finish.");
                break;
            }

        } while (true);
    }
}
