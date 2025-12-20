import java.util.Scanner;

public class TwoDToOneDArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter number of rows: ");
		int rows = scanner.nextInt();
		System.out.print("Please enter number of columns: ");
		int columns = scanner.nextInt();
		if (rows <= 0 || columns <= 0) {
			System.out.println("Invalid input");
			scanner.close();
			return;
		}
		int matrix[][] = new int[rows][columns];
		System.out.println("Please enter matrix elements:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		int array[] = new int[rows * columns];
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[index++] = matrix[i][j];
			}
		}
		System.out.print("1D Array elements: ");
		for (int i = 0; i < index; i++) {
			System.out.print(array[i] + " ");
		}
		scanner.close();
	}
}
