import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		for (int i = 6; i <= 9; i++) {
			System.out.printf("%d X %d = %d%n", num, i, num * i);
		}
		scanner.close();
	}

}
