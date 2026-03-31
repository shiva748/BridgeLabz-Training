import java.util.Scanner;

public class GreatestFactor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.printf("Greatest factor of %d beside itself is %d%n", num, num / i);
				break;
			}
		}
		scanner.close();
	}

}
