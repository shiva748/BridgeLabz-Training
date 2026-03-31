import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.printf("%d is %s number%n", i, i % 2 == 0 ? "even" : "odd");
		}
		scanner.close();
	}

}
