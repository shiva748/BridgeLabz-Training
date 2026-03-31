import java.util.Scanner;

public class FizzBuzzWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a Natural number:- ");
		int num = scanner.nextInt();
		int i = 1;
		while (i <= num) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
			i++;
		}
		scanner.close();
	}

}
