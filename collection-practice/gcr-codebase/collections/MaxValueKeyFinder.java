import java.util.HashMap;
import java.util.Map;

public class MaxValueKeyFinder {

    public static void main(String[] args) {

        Map<String, Integer> data = new HashMap<>();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (String key : data.keySet()) {
            int value = data.get(key);
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }

        System.out.println("Key with highest value: " + maxKey);
    }
}
