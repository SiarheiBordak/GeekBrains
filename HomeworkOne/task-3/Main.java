public class Main {

    public static void main(String[] args) {
        
    }

    public static float expressionEvaluation(float a, float b, float c, float d) {
        float result = 0;

        if(d == 0) {
            System.out.println("Argument 'd' can't be 0.");
        } else {
            result = a * (b + (c / d));
        }

        return result;
    }
}
