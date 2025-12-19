import java.util.Scanner;

public class SumOfNaturalNumberCompare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number:- ");
		int num = scanner.nextInt();
		int sumbyformula = num * (num + 1) / 2;
		int sum = 0;
		while (num > 0) {
			sum += num--;
		}
		System.out.printf("Sum of %d natural number by formula is %d and by loop %d and both are equal", num,
				sumbyformula, sum);
		scanner.close();
	}

}
