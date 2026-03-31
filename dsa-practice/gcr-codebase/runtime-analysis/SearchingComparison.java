import java.util.Arrays;

public class SearchingComparison {

	public static void main(String[] args) {
		int[] array = { 41, 7, 92, 18, 63, 29, 84, 56, 10, 75, 34, 88, 2, 69, 51, 97, 26, 60, 14, 80, 5, 47, 99, 31, 66,
				21, 73, 12, 58, 90, 3, 45, 68, 17, 54, 86, 24, 71, 39, 95, 1, 64, 27, 82, 49, 11, 77, 36, 59, 100 };

		int target = 99;

		int[] linearArray = Arrays.copyOf(array, array.length);
		int[] binaryArray = Arrays.copyOf(array, array.length);

		System.out.println("Linear Search time: " + linearSearch(linearArray, target) + " ns");
		System.out.println("Binary Search time: " + binarySearch(binaryArray, target) + " ns");
	}

	public static long linearSearch(int[] array, int target) {
		long startTime = System.nanoTime();

		for (int value : array) {
			if (value == target) {
				break;
			}
		}

		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	public static long binarySearch(int[] array, int target) {
		Arrays.sort(array);
		int left = 0, right = array.length - 1;

		long startTime = System.nanoTime();

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				break;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		long endTime = System.nanoTime();
		return endTime - startTime;
	}
}
