import java.util.Scanner;

public class FirstNegativeSearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}

		int index = findFirstNegative(numbers);

		if (index == -1) {
			System.out.println("No negative number found in the array");
		} else {
			System.out.println("First negative number found at index: " + index);
		}

		scanner.close();
	}

	public static int findFirstNegative(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				return i;
			}
		}
		return -1;
	}
}
