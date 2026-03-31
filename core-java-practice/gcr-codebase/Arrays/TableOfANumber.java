import java.util.Scanner;

public class TableOfANumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number ");
		int num = scanner.nextInt();
		int table[] = new int[10];
		for (int i = 0; i < table.length; i++) {
			table[i] = num * (i + 1);
			System.out.printf("%d * %d = %d%n", num, i + 1, table[i]);
		}
		scanner.close();
	}

}
