import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] words = { "Alabama", "Arizona", "Colorado", "Iowa", "California",
                "Washington", "Nevada", "Missouri", "Illinois", "Kentucky", "Iowa",
                "Texas", "Hawaii", "Louisiana", "Washington", "Texas", "Nebraska"};

        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String word: words) {
            Integer res = hashMap.get(word);
            hashMap.put(word, res == null ? 1 : res + 1);
        }

        System.out.println(hashMap);
    }
}
