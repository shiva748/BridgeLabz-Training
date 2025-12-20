import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int arr[] = new int[4];
		int num = scanner.nextInt();
		for (int i = 6; i <= 9; i++) {
			arr[i - 6] = num * i;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d X %d = %d%n", num, i + 6, arr[i]);

		}
		scanner.close();
	}

}
