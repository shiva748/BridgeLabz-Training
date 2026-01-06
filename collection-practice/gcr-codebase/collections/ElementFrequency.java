import java.util.HashMap;

public class ElementFrequency {
	public static void main(String[] args) {
		String[] fruits = { "apple", "banana", "apple", "orange" };
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : fruits) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		System.out.print(map);
	}
}