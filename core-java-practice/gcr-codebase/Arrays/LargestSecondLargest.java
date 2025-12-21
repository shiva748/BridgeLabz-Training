import java.util.Scanner;

public class LargestSecondLargest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number ");
		int number = scanner.nextInt();
		int maxDigit = 10;
		int digits[] = new int[maxDigit];
		int index = 0;
		while (number != 0) {
			if (index == maxDigit) {
				break;
			}
			digits[index] = number % 10;
			number = number / 10;
			index++;
		}
		int largest = 0;
		int secondLargest = 0;
		for (int i = 0; i < index; i++) {
			if (digits[i] > largest) {
				secondLargest = largest;
				largest = digits[i];
			} else if (digits[i] > secondLargest && digits[i] != largest) {
				secondLargest = digits[i];
			}
		}
		System.out.printf("Largest digit is %d%n", largest);
		System.out.printf("Second largest digit is %d%n", secondLargest);

		scanner.close();
	}
}
