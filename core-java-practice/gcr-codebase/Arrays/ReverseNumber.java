import java.util.Scanner;
import java.lang.Math;
public class ReverseNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int number = scanner.nextInt();
		int digits[] = new int[(int) Math.log10(number)+1];
		for(int i = 0; i < digits.length; i++) {
			digits[i] = number%10;
			number/=10;
		}
		for (int i = 0; i < digits.length; i++) {
			System.out.print(digits[i]+" ");
		}
		scanner.close();
	}

}
