import java.util.Scanner;

public class FactorialRecursion {

	public static long factorial(int n) {
		if(n <= 1) return 1L;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a non-negative integer: ");
		int n = scanner.nextInt();
		System.out.printf("factorial of %d is %d", n, factorial(n));
		scanner.close();
	}

}