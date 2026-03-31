import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter month:- ");
		int month = scanner.nextInt();
		System.out.print("Please enter day:- ");
		int day = scanner.nextInt();
		if (month == 4 || month == 5 || (month == 3 && day >= 20) || (month == 6 && day <= 20)) {
			System.out.println("Its a spring season");
		} else {
			System.out.println("Not a spring season");
		}
		scanner.close();
	}

}
