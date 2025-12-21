import java.util.Scanner;

public class TallestYoungest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String names[] = {"Amar", "Akbar", "Anthony"};
		int age[] = new int[3];
		double height[] = new double[3];
		for (int i = 0; i < height.length; i++) {
			System.out.printf("Please enter age of %s ", names[i]);
			age[i] = scanner.nextInt();
			System.out.printf("Please enter height of %s ", names[i]);
			height[i] = scanner.nextDouble();
		}
		int tallest = 0, youngest = 0;
		for(int i = 1; i < height.length; i++) {
			if(age[youngest] > age[i]) {
				youngest = i;
			}
			if(height[tallest] < height[i]) {
				tallest = i;
			}
		}
		System.out.printf("Tallest person is %s with height %.2f%n", names[tallest], height[tallest]);
		System.out.printf("Youngest person is %s with height %d%n", names[youngest], age[youngest]);
		scanner.close();
		
	}

}
