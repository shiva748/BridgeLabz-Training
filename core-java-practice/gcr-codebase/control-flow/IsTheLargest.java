import java.util.Scanner;

public class IsTheLargest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter num1:- ");
		int num1 = scanner.nextInt();
		System.out.print("Please enter num2:- ");
		int num2 = scanner.nextInt();
		System.out.print("Please enter num3:- ");
		int num3 = scanner.nextInt();
		int largest = Math.max(num1, Math.max(num2, num3));
		System.out.printf("Is the first number largest? %s%n", num1 == largest ? "Yes" : "No");
		System.out.printf("Is the second number largest? %s%n", num2 == largest ? "Yes" : "No");
		System.out.printf("Is the third number largest? %s", num3 == largest ? "Yes" : "No");
		scanner.close();
	}

}
