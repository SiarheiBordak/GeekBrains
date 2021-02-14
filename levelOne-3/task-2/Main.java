import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       playGame();
    }

    public static String createsWordsComputer() {
        Random random = new Random();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        return words[random.nextInt(26)];
    }

    public static String createsWordsUser() {
        Scanner scanner =new Scanner(System.in);
        String words;

        System.out.println("Enter words.");
        words = scanner.next();

        return words;
    }

    public static void searchSymbols(String computerWords, String userWords) {
        char[] array = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

        for (int i = 0; i < computerWords.length() & i < userWords.length(); i++) {
            if (computerWords.charAt(i) == userWords.charAt(i)) {
                array[i] = userWords.charAt(i);
            }
        }

        System.out.println(array);
    }

    public static void playGame(){
        String computerWords = createsWordsComputer();
        boolean flag = true;

        while (flag) {
            String userWords = createsWordsUser();
            if (computerWords.equals(userWords)) {
                System.out.println("You won!");
                flag = false;
            } else {
                searchSymbols(computerWords, userWords);
            }
        }
    }

}
