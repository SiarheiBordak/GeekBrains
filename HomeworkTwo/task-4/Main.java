public class Main {

    public static void main(String[] args) {
	    int[][] arrays = new int[5][5];

	    for (int i = 0; i < arrays.length; i++) {
	        for (int j = 0; j < arrays.length; j++) {
	            if (i == j) {
	                arrays[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if (i + j == arrays.length - 1) {
                    arrays[i][j] = 1;
                }
            }
        }
    }
}
