import java.util.Scanner;

public class GreatestFactorWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int i = 2;
		while (i < num) {
			if (num % i == 0) {
				System.out.printf("Greatest factor of %d beside itself is %d%n", num, num / i);
				break;
			}
			i++;
		}
		scanner.close();
	}

}