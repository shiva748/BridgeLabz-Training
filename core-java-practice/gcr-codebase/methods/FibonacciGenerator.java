import java.util.Scanner;

public class FibonacciGenerator {

	public static void generateFibonacci(int n) {
		if(n <= 0) {
			System.out.println("no terms to display");
			return;
		}
		int a = 0, b = 1;
		System.out.print(a);
		if(n > 1) System.out.print(" " + b);
		for(int i = 3; i <= n; i++) {
			int c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter number of terms: ");
		int n = scanner.nextInt();
		generateFibonacci(n);
		scanner.close();
	}

}