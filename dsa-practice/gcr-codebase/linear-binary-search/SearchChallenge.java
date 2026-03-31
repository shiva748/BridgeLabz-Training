import java.util.Arrays;
import java.util.Scanner;

public class SearchChallenge {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the list: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		System.out.println("Enter the elements:");
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}

		int missing = findFirstMissingPositive(numbers);
		System.out.println("First missing positive integer: " + missing);

		System.out.print("Enter target value to search: ");
		int target = scanner.nextInt();

		Arrays.sort(numbers);

		int index = binarySearch(numbers, target);

		if (index == -1) {
			System.out.println("Target not found");
		} else {
			System.out.println("Target found at index: " + index);
		}

		scanner.close();
	}

	// Linear Search logic
	public static int findFirstMissingPositive(int[] arr) {

		boolean[] visited = new boolean[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] <= arr.length) {
				visited[arr[i]] = true;
			}
		}

		for (int i = 1; i <= arr.length; i++) {
			if (!visited[i]) {
				return i;
			}
		}
		return arr.length + 1;
	}

	// Binary Search logic
	public static int binarySearch(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
