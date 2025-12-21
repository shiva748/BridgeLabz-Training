import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter number of persons ");
		int persons = scanner.nextInt();
		double weight[] = new double[persons];
		double height[] = new double[persons];
		double bmi[] = new double[persons];
		String status[] = new String[persons];
		for (int i = 0; i < persons; i++) {
			System.out.printf("Please enter weight of person %d ", i + 1);
			weight[i] = scanner.nextDouble();
			System.out.printf("Please enter height of person %d ", i + 1);
			height[i] = scanner.nextDouble();
		}
		for (int i = 0; i < persons; i++) {
			bmi[i] = weight[i] / (height[i] * height[i]);
			if (bmi[i] < 18.5) {
				status[i] = "Underweight";
			} else if (bmi[i] < 25) {
				status[i] = "Normal";
			} else if (bmi[i] < 30) {
				status[i] = "Overweight";
			} else {
				status[i] = "Obese";
			}
		}
		System.out.println("Height\tWeight\tBMI\tStatus");
		for (int i = 0; i < persons; i++) {
			System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
					height[i], weight[i], bmi[i], status[i]);
		}
		scanner.close();
	}
}
