import java.util.Scanner;

public class LeapYearLogical {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter year:- ");
		int year = scanner.nextInt();
		scanner.close();
		if (year < 1582) {
			System.out.println("Invalid year");
			return;
		}

		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) {
			System.out.printf("%d is a leap year", year);
		} else {
			System.out.printf("%d is not a leap year", year);
		}
	}

}
