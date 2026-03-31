import java.util.Scanner;
import java.util.function.Function;

public class MaxHandshake {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter number of students: ");
		int student = scanner.nextInt();
		Function<Integer, Integer> handshake = (a)-> a*(a-1)/2;
		System.out.printf("Maximum number of handshake between %d studets is %d", student,handshake.apply(student));
		scanner.close();
	}

}
