import java.util.Scanner;

public class EmployeeIdSorter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of employees: ");
		int count = scanner.nextInt();

		int[] employeeIds = new int[count];

		System.out.println("Enter employee IDs:");
		for (int i = 0; i < count; i++) {
			employeeIds[i] = scanner.nextInt();
		}

		for (int i = 1; i < count; i++) {
			int currentId = employeeIds[i];
			int position = i - 1;

			while (position >= 0 && employeeIds[position] > currentId) {
				employeeIds[position + 1] = employeeIds[position];
				position--;
			}

			employeeIds[position + 1] = currentId;
		}

		System.out.println("Employee IDs after sorting:");
		for (int id : employeeIds) {
			System.out.print(id + " ");
		}

		scanner.close();
	}
}
