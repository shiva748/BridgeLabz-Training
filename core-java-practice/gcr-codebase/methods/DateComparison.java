import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter first date (yyyy-MM-dd): ");
		LocalDate d1 = LocalDate.parse(scanner.nextLine().trim());
		System.out.print("please enter second date (yyyy-MM-dd): ");
		LocalDate d2 = LocalDate.parse(scanner.nextLine().trim());
		
		if(d1.isBefore(d2)) {
			System.out.println(d1 + " is before " + d2);
		}else if(d1.isAfter(d2)) {
			System.out.println(d1 + " is after " + d2);
		}else if(d1.isEqual(d2)) {
			System.out.println(d1 + " is equal to " + d2);
		}
		
		scanner.close();
	}

}