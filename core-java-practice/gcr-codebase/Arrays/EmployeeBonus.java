import java.util.Scanner;

public class EmployeeBonus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double salary[] = new double[10];
		double service[] = new double[10];
		double bonus[] = new double[10];
		double newSalary[] = new double[10];
		double totalBonus = 0;
		double totalOldSalary = 0;
		double totalNewSalary = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter salary for employee " + (i + 1) + ": ");
			salary[i] = scanner.nextDouble();
			System.out.print("Enter years of service for employee " + (i + 1) + ": ");
			service[i] = scanner.nextDouble();
			if (salary[i] <= 0 || service[i] < 0) {
				System.out.println("Invalid input, please enter again");
				i--;
			}
		}
		for (int i = 0; i < 10; i++) {
			if (service[i] > 5) {
				bonus[i] = salary[i] * 0.05;
			} else {
				bonus[i] = salary[i] * 0.02;
			}
			newSalary[i] = salary[i] + bonus[i];
			totalBonus += bonus[i];
			totalOldSalary += salary[i];
			totalNewSalary += newSalary[i];
		}
		System.out.println("Total bonus amount to be paid: " + totalBonus);
		System.out.println("Total old salary of all employees: " + totalOldSalary);
		System.out.println("Total new salary of all employees: " + totalNewSalary);

		scanner.close();
	}
}
