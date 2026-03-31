import java.util.Scanner;

public class FactorArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int number = scanner.nextInt();

		if (number <= 0) {
			System.out.println("Invalid input.");
			scanner.close();
			return;
		}
		int maxFactor = 10;
		int factors[] = new int[maxFactor];
		int index = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				if (index == maxFactor) {
					maxFactor = maxFactor * 2;
					int temp[] = new int[maxFactor];
					for (int j = 0; j < factors.length; j++) {
						temp[j] = factors[j];
					}
					factors = temp;
				}
				factors[index++] = i;
			}
		}
		System.out.print("Factors of " + number + ": ");
		for (int i = 0; i < index; i++) {
			System.out.print(factors[i] + " ");
		}
		scanner.close();
	}
}
