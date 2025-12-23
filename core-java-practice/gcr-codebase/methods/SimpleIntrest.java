import java.util.Scanner;

public class SimpleIntrest {

	public static double simpleIntrest(int principal, double rate, int duration) {
		return principal*rate*duration/100;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter principle amount: ");
		int principal = scanner.nextInt();
		System.out.print("please enter rate of intrest: ");
		double rate = scanner.nextInt();
		System.out.print("please enter duration: ");
		int duration = scanner.nextInt();
		System.out.printf("The Simple Interest is %.2f for Principal %d, Rate of Interest %.2f and Time %d", simpleIntrest(principal, rate, duration), principal, rate, duration);
		scanner.close();

	}

}
