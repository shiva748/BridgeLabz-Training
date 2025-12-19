import java.util.Scanner;

public class CountDown {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a timer:- ");
		int timer = scanner.nextInt();
		while (timer > 0) {
			System.out.println(timer--);
		}
		System.out.println("Launch");
		scanner.close();
	}

}
