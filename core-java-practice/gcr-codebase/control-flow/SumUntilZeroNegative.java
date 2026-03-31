import java.util.Scanner;

public class SumUntilZeroNegative {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double sum = 0;
		System.out.print("Please start entering number's or 0 to stop:- ");
		while (true) {
			Double num = scanner.nextDouble();
			sum += num;
			if (num <= 0) {
				System.out.println("Total Sum is :- " + sum);
				scanner.close();
				return;
			}
		}
	}

}
