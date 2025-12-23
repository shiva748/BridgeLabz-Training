import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a date (yyyy-MM-dd): ");
		String input = scanner.nextLine().trim();
		LocalDate date = LocalDate.parse(input);
		
		LocalDate added = date.plusDays(7).plusMonths(1).plusYears(2);
		LocalDate result = added.minusWeeks(3);
		
		System.out.printf("original date : %s\n", date);
		System.out.printf("after +7 days, +1 month, +2 years : %s\n", added);
		System.out.printf("after -3 weeks : %s\n", result);
		
		scanner.close();
	}

}