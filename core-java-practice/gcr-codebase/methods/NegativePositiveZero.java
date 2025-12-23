import java.util.Scanner;
import java.util.function.Function;

public class NegativePositiveZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a number: ");
		int num = scanner.nextInt();
		Function<Integer, Integer> type = (a)-> a < 0?-1:a > 0?1:0;
		System.out.print(type.apply(num));
		scanner.close();
	}

}
