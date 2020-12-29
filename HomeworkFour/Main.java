import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start(4);
    }

    static void start(int size) {
        char[][] field = getField(size);

        do {
            handlePlayerMove(field);
            drawField(field);

            if (checkFinal(field, 'X')) {
                break;
            }

            System.out.println();

            handleAIMove(field);
            drawField(field);

            if (checkFinal(field, '0')) {
                break;
            }

        } while (true);
    }

    static boolean checkFinal(char[][] field, char sign) {
        if (checkWin(field, sign)) {
            String name = sign == 'X' ? "Player" : "Computer";
            System.out.printf("Congrats!!! %s is winner!%n", name);
            return true;
        }
        if (isDraw(field)) {
            System.out.println("There is draw!!!");
            return true;
        }
        return false;
    }

    static boolean isDraw(char[][] field) {
        int moves = field.length * field.length;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != emptySymbol()) {
                    moves--;
                }
            }
        }

        return moves == 0;
    }

    static boolean checkWin(char[][] field, char sign) {
        if (checkHorizontalAndVertical(field, sign) ||  checkDiagonals(field, sign)) {
            return true;
        }

        return false;
    }

    static boolean checkHorizontalAndVertical(char[][] field, char sign) {
        int counterHorizontal = 0;
        int counterVertical = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == sign) {
                    counterHorizontal++;
                }

                if (field[j][i] == sign) {
                    counterVertical++;
                }
            }

            if (counterHorizontal == field.length || counterVertical == field.length) {
                return true;
            } else {
                counterHorizontal = 0;
                counterVertical = 0;
            }
        }

        return false;
    }

    static boolean checkDiagonals(char[][] field, char sign) {
        int counterMainDiagonal = 0;
        int counterSideDiagonal = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == j && field[i][j] == sign) {
                    counterMainDiagonal++;
                }

                if (i + j == field.length - 1 && field[i][j] == sign) {
                    counterSideDiagonal++;
                }
            }
        }

        if (counterMainDiagonal == field.length || counterSideDiagonal == field.length) {
            return true;
        }

        return false;
    }

    static void handleAIMove(char[][] field) {
        Random random = new Random();
        boolean flag = true;
        int x = 0;
        int y = 0;
        int counter = 0;

        // checking the horizontal for blocking
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'X') {
                    counter++;
                } else {
                    x = i;
                    y = j;
                }
            }

            if (counter == field.length - 1 && field[x][y] == '-') {
                field[x][y] = '0';
                flag = false;
                break;
            }
            else {
                counter = 0;
            }
        }

        // checking the vertical for blocking
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == 'X') {
                    counter++;
                } else {
                    x = j;
                    y = i;
                }
            }

            if (counter == field.length - 1 && field[x][y] == '-') {
                field[x][y] = '0';
                flag = false;
                break;
            }
            else {
                counter = 0;
            }
        }

        // checking the main diagonal for blocking
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == j && field[i][j] == 'X') {
                    counter++;
                } else if (i == j && field[i][j] == '-') {
                    x = i;
                    y = j;
                }
            }
        }

        if (counter == field.length - 1) {
            field[x][y] = '0';
            flag = false;
        } else {
            counter = 0;
        }

        // checking the side diagonal for blocking
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i + j == field.length - 1 && field[i][j] == 'X') {
                    counter++;
                } else if (i + j == field.length - 1 && field[i][j] == '-') {
                    x = i;
                    y = j;
                }
            }
        }

        if (counter == field.length - 1) {
            field[x][y] = '0';
            flag = false;
        }

        if (flag) {
            do {
                x = random.nextInt(field.length);
                y = random.nextInt(field.length);
            } while (isEmptyCoordinates(field, x, y));
            field[x][y] = '0';
        }

    }

    static void handlePlayerMove(char[][] field) {
        int x, y;
        do {
            System.out.println("Please choose coordinates [X, Y]...");
            x = chooseCoordinate('X', field.length);
            y = chooseCoordinate('Y', field.length);
        } while (isEmptyCoordinates(field, x, y));
        field[x][y] = 'X';
    }

    static boolean isEmptyCoordinates(char[][] field, int x, int y) {
        return field[x][y] != emptySymbol();
    }

    static int chooseCoordinate(char sign, int size) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Please enter %s-coordinate [Range 1..%d]...%n", sign, size);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate > size);

        return coordinate;
    }

    static char[][] getField(int size) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = emptySymbol();
            }
        }
        return field;
    }

    static char emptySymbol() {
        return '-';
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}