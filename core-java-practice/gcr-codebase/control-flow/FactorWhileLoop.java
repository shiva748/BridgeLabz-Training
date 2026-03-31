import java.util.Scanner;

public class FactorWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int i = 1;
		while (i <= num) {
			if (i == num) {
				System.out.println(num);
			} else if (num % i == 0) {
				System.out.printf("%d, ", i);
			}
			i++;
		}
		scanner.close();
	}

}
