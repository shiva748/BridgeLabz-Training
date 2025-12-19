import java.util.Scanner;

public class IsSmallest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter num1:- ");
		int num1 = scanner.nextInt();
		System.out.print("Please enter num2:- ");
		int num2 = scanner.nextInt();
		System.out.print("Please enter num3:- ");
		int num3 = scanner.nextInt();
		System.out.printf("Is the first number the smallest? %s",
				Math.min(num1, Math.min(num2, num3)) == num1 ? "Yes" : "No");
		scanner.close();
	}

}
