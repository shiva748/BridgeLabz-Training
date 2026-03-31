import java.util.Scanner;

public class FizzBuzzArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number");
		int number = scanner.nextInt();
		if (number <= 0) {
			System.out.println("Invalid Input");
			scanner.close();
			return;
		}
		String result[] = new String[number];
		for (int i = 1; i <= number; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result[i - 1] = "FizzBuzz";
			} else if (i % 3 == 0) {
				result[i - 1] = "Fizz";
			} else if (i % 5 == 0) {
				result[i - 1] = "Buzz";
			} else {
				result[i - 1] = String.valueOf(i);
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println("Position " + (i + 1) + " = " + result[i]);
		}
		scanner.close();
	}
}
