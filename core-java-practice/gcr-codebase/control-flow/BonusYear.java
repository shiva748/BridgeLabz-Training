import java.util.Scanner;

public class BonusYear {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your salary:- ");
		int salary = scanner.nextInt();
		System.out.print("Please enter your year of service:- ");
		int year = scanner.nextInt();
		if (year > 5) {
			System.out.printf("Bonus amount is INR %.2f%n", salary * 0.05);
		} else {
			System.out.println("No Bonus Provided");
		}
		scanner.close();
	}

}
