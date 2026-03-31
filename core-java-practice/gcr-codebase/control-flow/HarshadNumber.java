import java.util.Scanner;

public class HarshadNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int sum = 0;
		for (int i = num; i > 0; i /= 10) {
			sum += i % 10;
		}
		System.out.printf("%d is %s Harshad number", num, num % sum == 0 ? "a" : "not a");
		scanner.close();
	}

}
