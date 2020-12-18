public class Main {

    public static void main(String[] args) {

    }

    public static void definitionOfTheYear(int year) {
        if(year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Год високосный");
                } else {
                    System.out.println("Год невисокосный");
                }
            } else {
                System.out.println("Год високосный");
            }
        } else {
            System.out.println("Год невисокосный");
        }
    }
}
