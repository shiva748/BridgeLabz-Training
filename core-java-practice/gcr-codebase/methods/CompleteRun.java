import java.util.Scanner;
import java.util.function.Function;

public class CompleteRun {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int perimeter = 0;
		for(int i = 1; i <= 3; i++) {
			System.out.printf("please enter side %d of triangle in meter: ", i);
			perimeter += scanner.nextInt();
		}
		Function<Integer, Double> calculateRound = (p) -> {
			return (double) 5000/p;
		};
		System.out.printf("Runner must make %.2f rounds to complete 5km run", calculateRound.apply(perimeter));
		scanner.close();
		
	}

}
