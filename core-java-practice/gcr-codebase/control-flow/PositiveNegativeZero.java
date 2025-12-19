import java.util.Scanner;

public class PositiveNegativeZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		System.out.println(num < 0?"Negative":num > 0?"Positive":"Zero");
		scanner.close();
	}

}
