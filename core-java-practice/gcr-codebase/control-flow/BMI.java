import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your weight in kg:- ");
		double weight = scanner.nextDouble();
		System.out.print("Please enter your height in cm:- ");
		double height = scanner.nextDouble();
		double bmi = weight / Math.pow(height / 100, 2);
		if (bmi <= 18.4) {
			System.out.println("UnderWeight");
		} else if (bmi >= 18.5 && bmi <= 24.9) {
			System.out.println("Normal");
		} else if (bmi >= 25.0 && bmi <= 39.9) {
			System.out.println("Overweight");
		} else {
			System.out.println("Obese");
		}
	}

}
