import java.util.Arrays;
import java.util.Scanner;

public class AverageHeight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double height[] = new double[11];
		System.out.print("Please enter height of player in meters: ");
		for (int i = 0; i < height.length; i++) {
			height[i] = scanner.nextDouble();
		}
		System.out.printf("Mean height of player's in foot ball team is %.2f meter",
				Arrays.stream(height).sum() / height.length);
		scanner.close();
	}

}
