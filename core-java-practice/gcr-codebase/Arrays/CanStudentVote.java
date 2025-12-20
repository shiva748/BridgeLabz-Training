import java.util.Scanner;

public class CanStudentVote {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int age[] = new int[10];
		System.out.print("Please enter age of 10 students ");
		for (int i = 0; i < age.length; i++) {
			age[i] = scanner.nextInt();
		}
		for (int i = 0; i < age.length; i++) {
			if (age[i] < 0) {
				System.out.println("Invalid Age.");
			} else {
				System.out.printf("The Student with age %d %s vote%n", age[i], age[i] >= 18 ? "can" : "cannot");
			}
		}
		scanner.close();
	}

}
