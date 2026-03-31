import java.util.Scanner;

public class Multiple {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number between 1 and 100:- ");
		int num = scanner.nextInt();
		if (num <= 100 && num >= 1) {
			for (int i = 100; i >= num; i--) {
				if (i % num == 0) {
					System.out.print(i + " ");
				}
			}
		} else {
			System.out.println("Invalid input");
		}
		scanner.close();
	}

}
