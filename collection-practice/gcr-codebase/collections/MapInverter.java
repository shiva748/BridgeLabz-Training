import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInverter {

    public static void main(String[] args) {

        Map<String, Integer> source = new HashMap<>();
        source.put("A", 1);
        source.put("B", 2);
        source.put("C", 1);

        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            inverted
                .computeIfAbsent(entry.getValue(), v -> new ArrayList<>())
                .add(entry.getKey());
        }

        System.out.println(inverted);
    }
}
