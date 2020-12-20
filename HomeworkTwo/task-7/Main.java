import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] arrays = {1, 2, 3, 4};

	    swapsTheElementsOfAnArray(arrays, -3);

        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    public static void swapsTheElementsOfAnArray (int[] array, int position) {
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                int n = array[array.length - 1];

                for(int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }

                array[0] = n;
            }
        } else {
            for (int i = 0; i > position; i--) {
                int n = array[0];

                for(int j = 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }

                array[array.length - 1] = n;
            }
        }
    }
}
