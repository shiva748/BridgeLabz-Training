import java.util.Scanner;

public class RotationPointSearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		System.out.println("Enter the elements of the rotated sorted array:");
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}

		int index = findRotationPoint(numbers);

		System.out.println("Rotation point index: " + index);
		System.out.println("Smallest element: " + numbers[index]);

		scanner.close();
	}

	public static int findRotationPoint(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int mid = (left + right) / 2;

			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
