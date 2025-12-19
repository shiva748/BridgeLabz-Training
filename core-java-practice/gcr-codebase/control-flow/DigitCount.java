import java.util.Scanner;

public class DigitCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		System.out.printf("number of digit in %d is %d", num, (int) Math.log10(num) + 1);
		scanner.close();
	}

}
