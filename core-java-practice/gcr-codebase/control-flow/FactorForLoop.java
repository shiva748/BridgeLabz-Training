import java.util.Scanner;

public class FactorForLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			if (i == num) {
				System.out.println(num);
			} else if (num % i == 0) {
				System.out.printf("%d, ", i);
			}
		}
		scanner.close();
	}

}
