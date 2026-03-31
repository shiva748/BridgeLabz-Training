import java.util.Arrays;
import java.util.Scanner;

public class ZeroBalance {

	public static int count(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}
		return count;
	}

	public static void movezerotoend(int arr[]) {
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[j] != 0) {
				arr[i] = arr[j];
				i++;
			}
			j++;
		}
		while (i < arr.length) {
			arr[i] = 0;
			i++;
		}
	}

	public static void shiftBy(int arr[], int by, int nonzero) {
		int i = nonzero - 1;
		while (i >= 0) {
			arr[i + by] = arr[i];
			arr[i] = 0;
			i--;
		}
	}

	public static void balance(int arr[]) {
		int count = count(arr);

		movezerotoend(arr);

		shiftBy(arr, count / 2, arr.length - count);

		if (count % 2 != 0) {
			int mid = arr.length / 2;
			int end = arr.length - (count / 2) - 1;

			for (int i = end; i >= mid; i--) {
				arr[i + 1] = arr[i];
			}
			arr[mid] = 0;
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter size of array: ");
		int size = scanner.nextInt();
		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		balance(arr);
		scanner.close();
	}
}
