import java.util.Scanner;

public class StudentMarksSort {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter total number of students: ");
		int totalStudents = input.nextInt();

		int[] marksList = new int[totalStudents];

		System.out.println("Enter student marks:");
		for (int i = 0; i < totalStudents; i++) {
			marksList[i] = input.nextInt();
		}

		for (int i = 0; i < totalStudents - 1; i++) {
			boolean isSwapped = false;

			for (int j = 0; j < totalStudents - i - 1; j++) {
				if (marksList[j] > marksList[j + 1]) {
					int temp = marksList[j];
					marksList[j] = marksList[j + 1];
					marksList[j + 1] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped) {
				break;
			}
		}

		System.out.println("Marks after sorting in ascending order:");
		for (int mark : marksList) {
			System.out.print(mark + " ");
		}

		input.close();
	}
}
