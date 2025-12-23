import java.util.Scanner;

public class PrimeChecker {

	public static boolean isPrime(int num) {
		if(num <= 1) return false;
		if(num <= 3) return true;
		if(num % 2 == 0 || num % 3 == 0) return false;
		for(int i = 5; i * i <= num; i += 6) {
			if(num % i == 0 || num % (i + 2) == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a number: ");
		int n = scanner.nextInt();
		System.out.println(n + " is " + (isPrime(n) ? "prime" : "not prime"));
		scanner.close();
	}

}