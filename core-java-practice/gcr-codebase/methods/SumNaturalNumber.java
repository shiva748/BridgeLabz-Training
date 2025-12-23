import java.util.Scanner;
import java.util.function.Function;
public class SumNaturalNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int num = scanner.nextInt();
		Function<Integer, Integer> calculateSum = (a)->{
			int sum = 0;
			for(int i = 1; i<= a; i++) {
				sum += i;
			}
			return sum;
		};
		System.out.printf("sum of %d natural number is %d", num, calculateSum.apply(num));
		scanner.close();
	}

}
