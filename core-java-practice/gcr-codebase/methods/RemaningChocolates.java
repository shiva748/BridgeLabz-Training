import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RemaningChocolates {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter number of students: ");
		int sutdent = scanner.nextInt();
		System.out.print("Please enter number of chocolate: ");
		int chocolate = scanner.nextInt();
		BiConsumer<Integer, Integer> divison = (s, c)-> {
			System.out.printf("%d student will get %d chocolate each and %d chocolate will be remaning", s, c/s, c%s);
		};
		divison.accept(sutdent, chocolate);
		scanner.close();
	}

}
