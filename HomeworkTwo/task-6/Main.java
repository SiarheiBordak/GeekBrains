public class Main {

    public static void main(String[] args) {
        
    }

    public static boolean checkBalance(int[] array) {
        int RightSideSum = 0;

        for(int i = 0; i < array.length; i++) {
            RightSideSum += array[i];

            int leftSideSum = 0;

            for (int j = i + 1; j < array.length; j++) {
                leftSideSum += array[j];
            }

            if (RightSideSum == leftSideSum) {
                return true;
            }
        }

        return false;
    }
}
