import java.util.Scanner;

public class YoungestTallestFriend {
	public static int tallest(double height[]) {
		int tallest = 0;
		for(int i = 1; i < height.length; i++) {
			if(height[tallest] < height[i]) {
				tallest = i;
			}
		}
		return tallest;
	}
	
	public static int youngest(int age[]) {
		int youngest = 0;
		for(int i = 1; i < age.length; i++) {
			if(age[youngest] > age[i]) {
				youngest = i;
			}
		}
		return youngest;
	}
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
		
		System.out.printf("Tallest person is %s with height %.2f%n", names[tallest(height)], height[tallest(height)]);
		System.out.printf("Youngest person is %s with height %d%n", names[youngest(age)], age[youngest(age)]);
		scanner.close();
	}

}
