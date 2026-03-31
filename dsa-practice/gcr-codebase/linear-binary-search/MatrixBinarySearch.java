import java.util.Scanner;

public class MatrixBinarySearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();

		System.out.print("Enter number of columns: ");
		int columns = scanner.nextInt();

		int[][] matrix = new int[rows][columns];

		System.out.println("Enter the elements of the matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		System.out.print("Enter the target value to search: ");
		int target = scanner.nextInt();

		boolean found = searchMatrix(matrix, rows, columns, target);

		if (found) {
			System.out.println("Target value found in the matrix");
		} else {
			System.out.println("Target value not found in the matrix");
		}

		scanner.close();
	}

	public static boolean searchMatrix(int[][] matrix, int rows, int columns, int target) {

		int left = 0;
		int right = rows * columns - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			int row = mid / columns;
			int col = mid % columns;

			if (matrix[row][col] == target) {
				return true;
			}

			if (matrix[row][col] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}
