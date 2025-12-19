import java.util.Scanner;

public class FactorialWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int factorial = 1;
		while (num > 1) {
			factorial *= num--;
		}
		System.out.println("factorial calculated is :- " + factorial);
		scanner.close();
	}
}
