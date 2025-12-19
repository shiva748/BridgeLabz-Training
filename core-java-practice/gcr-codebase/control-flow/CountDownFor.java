import java.util.Scanner;

public class CountDownFor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a timer:- ");
		int timer = scanner.nextInt();
		for (; timer > 0; timer--) {
			System.out.println(timer);
		}
		System.out.println("Launch");
		scanner.close();
	}

}
