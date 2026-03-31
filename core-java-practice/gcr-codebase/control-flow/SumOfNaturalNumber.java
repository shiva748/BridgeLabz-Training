import java.util.Scanner;

public class SumOfNaturalNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		if(num < 0) {
			System.out.printf("The number %d is not a natural number", num);
		}else {
			System.out.printf("The sum of %d natural number is %d ", num, num*(num+1)/2);
		}
		scanner.close();
	}

}
