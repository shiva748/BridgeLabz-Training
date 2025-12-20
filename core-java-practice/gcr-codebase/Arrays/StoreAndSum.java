import java.util.Scanner;

public class StoreAndSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[10];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			if (arr[i] <= 0) {
				break;
			}
			sum += arr[i];
		}
		System.out.printf("Sum of element in array is %d", sum);
		scanner.close();
	}

}
