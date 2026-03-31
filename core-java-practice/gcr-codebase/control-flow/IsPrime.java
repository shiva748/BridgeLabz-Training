import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		scanner.close();
		for (int i = 2; num >= i * i; i++) {
			if (num % i == 0) {
				System.out.printf("%d is not a prime number", num);
				return;
			}
		}
		System.out.printf("%d is a prime number", num);
	}

}
