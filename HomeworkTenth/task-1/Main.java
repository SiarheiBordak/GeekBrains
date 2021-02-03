import ru.geekbrains.exceptions.MyArrayDataException;
import ru.geekbrains.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        String[][] arrays = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] arraysOne = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] arraysTwo = {
                {"1", "2", "3", "4"},
                {"1", "2", "4", "4"},
                {"1", "H", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] arraysThree = {
                {"1", "2", "3", "4"},
                {"1", "2", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println(method(arrays));
//            System.out.println(method(arraysOne));
//            System.out.println(method(arraysTwo));
//            System.out.println(method(arraysThree));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int method(String[][] arrays) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arrays.length != 4) {
            throw new MyArraySizeException(String.format("Invalid array size. Strings = %d ", arrays.length));
        }

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 4) {
                throw new MyArraySizeException(String.format("Invalid number of columns in row %d ", i + 1 , arrays.length));
            }

            for (int j = 0; j < arrays[i].length; j++) {
                try {
                    sum += Integer.parseInt(arrays[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Invalid array value! Error in cell: %dx%d", i + 1 , j + 1), e);
                }
            }
        }

        return sum;
    }
}
