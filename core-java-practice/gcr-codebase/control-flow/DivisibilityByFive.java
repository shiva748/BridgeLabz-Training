import java.util.Scanner;

public class DivisibilityByFive {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your Number:- ");
		int num = scanner.nextInt();
		System.out.printf("Is the number %d divisivle by 5? %s", num, num % 5 == 0 ? "Yes" : "No");
		scanner.close();
	}

}
