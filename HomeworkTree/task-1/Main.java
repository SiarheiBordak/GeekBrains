import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    public static boolean checkNumber(int playerNumber, int randomNumber) {
        return playerNumber > randomNumber;
    }

    public static int randomNumberInitialization() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public static boolean repeatTheInvitationToPlay(Scanner scanner) {
        System.out.println("Want to play the game again?");
        System.out.println("1 - Yes.");
        System.out.println("0 - No.");
        System.out.println("Enter Answer.");

        return scanner.nextInt() == 1;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = randomNumberInitialization();
        int playerNumber;

        for (int numberOfAttempts = 1; numberOfAttempts < 4; numberOfAttempts++) {
            System.out.println("Insert the number.");
            playerNumber = scanner.nextInt();

            if (playerNumber == randomNumber) {
                System.out.println("You won!");
                numberOfAttempts = repeatTheInvitationToPlay(scanner) ? 0 : 4;
                if (numberOfAttempts == 0 ) {
                    randomNumber = randomNumberInitialization();
                }
            } else if (checkNumber(playerNumber, randomNumber)) {
                System.out.println("Number more.");
            } else {
                System.out.println("Number less.");
            }

            if (numberOfAttempts == 3) {
                System.out.println("You lost!");
                numberOfAttempts = repeatTheInvitationToPlay(scanner) ? 0 : 4;
                if (numberOfAttempts == 0 ) {
                    randomNumber = randomNumberInitialization();
                }
            }
        }

        scanner.close();
    }
}
