import java.util.Scanner;

public class PowerLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		System.out.print("Please enter power:- ");
		int pow = scanner.nextInt();
		int res = 1;
		for (int i = 0; i < pow; i++) {
			res *= num;
		}
		System.out.println(res);
		scanner.close();
	}

}
