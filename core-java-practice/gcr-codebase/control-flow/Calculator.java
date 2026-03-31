import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter equation:- ");
		int num1 = scanner.nextInt();
		char op = scanner.next().charAt(0);
		int num2 = scanner.nextInt();
		switch (op) {
		case '+': {
			System.out.println(num1 + num2);
			break;
		}
		case '-': {
			System.out.println(num1 - num2);
			break;
		}
		case '*': {
			System.out.println(num1 * num2);
			break;
		}
		case '/': {
			System.out.println(num1 / num2);
			break;
		}
		default:
			System.out.println("unexpected operator");
		}
		scanner.close();
	}

}
