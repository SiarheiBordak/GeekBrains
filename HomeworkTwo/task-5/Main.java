public class Main {

    public static void main(String[] args) {
	    int[] array = {1, 0, -3, 56, 7, 7, 9, -8, 10, 5, 13};

	    int max = array[0];

	    for (int i = 0; i < array.length; i++) {
	        if (array[i] > max) {
	            max = array[i];
            }
        }

	    int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    }
}
