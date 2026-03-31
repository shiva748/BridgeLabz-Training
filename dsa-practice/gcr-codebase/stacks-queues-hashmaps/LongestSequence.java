import java.util.HashMap;
import java.util.Map;

class LongestConsecutiveSequence {

	int findLongestSequence(int[] arr) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int num : arr) {
			map.put(num, true);
		}

		int longest = 0;

		for (int num : arr) {
			if (!map.containsKey(num - 1)) {
				int current = num;
				int count = 1;

				while (map.containsKey(current + 1)) {
					current++;
					count++;
				}
				longest = Math.max(longest, count);
			}
		}
		return longest;
	}
}

public class LongestSequence {
	public static void main(String[] args) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };

		LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
		System.out.println(sequence.findLongestSequence(arr));
	}
}
