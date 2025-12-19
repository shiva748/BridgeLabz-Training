import java.util.Scanner;

public class MultipleWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number between 1 and 100:- ");
		int num = scanner.nextInt();
		if (num <= 100 && num >= 1) {
			int i = 100;
			while (i >= num) {
				if (i % num == 0) {
					System.out.print(i + " ");
				}
				i--;
			}
		} else {
			System.out.println("Invalid input");
		}
		scanner.close();
	}

}
