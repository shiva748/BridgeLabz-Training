import java.util.Scanner;

public class PeakElementSearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}

		int index = findPeakElement(numbers);

		System.out.println("Peak element index: " + index);
		System.out.println("Peak element value: " + numbers[index]);

		scanner.close();
	}

	public static int findPeakElement(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			boolean leftOk = (mid == 0) || arr[mid] > arr[mid - 1];
			boolean rightOk = (mid == arr.length - 1) || arr[mid] > arr[mid + 1];

			if (leftOk && rightOk) {
				return mid;
			}

			if (mid > 0 && arr[mid] < arr[mid - 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
