import java.util.HashMap;
import java.util.Map;

class PairSumChecker {

	boolean hasPairWithSum(int[] arr, int target) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int num : arr) {
			int required = target - num;

			if (map.containsKey(required)) {
				return true;
			}
			map.put(num, true);
		}
		return false;
	}
}

public class PairSum {
	public static void main(String[] args) {
		int[] arr = { 8, 7, 2, 5, 3, 1 };
		int target = 10;

		PairSumChecker checker = new PairSumChecker();
		System.out.println(checker.hasPairWithSum(arr, target));
	}
}
