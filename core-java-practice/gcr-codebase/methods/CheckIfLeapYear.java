import java.util.Scanner;
import java.util.function.Function;

public class CheckIfLeapYear {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter year: ");
		int year = scanner.nextInt();
		Function<Integer, Boolean> isLeapYear = (y)->{
			if (year < 1582) {
				return false;
			} else {
				if (year % 4 == 0) {
					if ((year % 100 == 0 && year % 400 == 0) || year % 100 != 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		};
		System.out.printf("%d is %s Leap year", year, isLeapYear.apply(year)?"a":"not a");
		scanner.close();
	}

}
