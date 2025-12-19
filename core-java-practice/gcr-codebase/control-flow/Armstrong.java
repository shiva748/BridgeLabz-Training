import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int digit = (int) Math.log10(num) + 1;
		int sum = 0;
		for (int i = num; i > 0; i /= 10) {
			sum += Math.pow(i % 10, digit);
		}
		System.out.printf("%d is %s armstrong number", num, num == sum ? "a" : "not a");
		scanner.close();
	}
}
