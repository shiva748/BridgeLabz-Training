import java.util.Scanner;

public class AbundantNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i < num; i++) {
			sum += num % i == 0 ? i : 0;
		}
		System.out.printf("%d is %s abundant number", num, sum > num ? "a" : "not a");
		scanner.close();
	}

}
