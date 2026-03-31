import java.util.Scanner;

public class MaxOfThree {

	public static int maxOfThree(int a, int b, int c) {
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter first number: ");
		int a = scanner.nextInt();
		System.out.print("please enter second number: ");
		int b = scanner.nextInt();
		System.out.print("please enter third number: ");
		int c = scanner.nextInt();
		System.out.printf("maximum of three numbers is %d", maxOfThree(a, b, c));
		scanner.close();
	}

}