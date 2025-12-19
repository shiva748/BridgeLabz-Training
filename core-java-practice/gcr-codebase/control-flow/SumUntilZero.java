import java.util.Scanner;

public class SumUntilZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		System.out.print("Please start entering number's or 0 to stop:- ");
		while (true) {
			int num = scanner.nextInt();
			sum += num;
			if (num == 0) {
				System.out.println("Total Sum is :- " + sum);
				scanner.close();
				return;
			}
		}

	}

}
