public class Main {

    public static void main(String[] args) {
        
    }

    public static boolean determiningTheNumber(int a) {
        boolean flag = false;

        if(a == 0) {
            System.out.println("number zero is not positive non-negative");
        } else if (a > 0) {
            flag = false;
        } else {
            flag = true;
        }

        return flag;
    }
}
