import java.util.Scanner;

public class BookPriceOrganizer {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		System.out.print("Enter number of books: ");
		int size = reader.nextInt();

		int[] priceArray = new int[size];

		System.out.println("Enter book prices:");
		for (int i = 0; i < size; i++) {
			priceArray[i] = reader.nextInt();
		}

		mergeSortPrices(priceArray, 0, size - 1);

		System.out.println("Book prices after sorting:");
		for (int price : priceArray) {
			System.out.print(price + " ");
		}

		reader.close();
	}

	private static void mergeSortPrices(int[] prices, int start, int end) {

		if (start < end) {
			int midPoint = (start + end) / 2;

			mergeSortPrices(prices, start, midPoint);
			mergeSortPrices(prices, midPoint + 1, end);

			mergeArrays(prices, start, midPoint, end);
		}
	}

	private static void mergeArrays(int[] prices, int left, int mid, int right) {

		int leftSize = mid - left + 1;
		int rightSize = right - mid;

		int[] leftPart = new int[leftSize];
		int[] rightPart = new int[rightSize];

		for (int i = 0; i < leftSize; i++) {
			leftPart[i] = prices[left + i];
		}

		for (int j = 0; j < rightSize; j++) {
			rightPart[j] = prices[mid + 1 + j];
		}

		int i = 0, j = 0, k = left;

		while (i < leftSize && j < rightSize) {
			if (leftPart[i] <= rightPart[j]) {
				prices[k] = leftPart[i];
				i++;
			} else {
				prices[k] = rightPart[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			prices[k] = leftPart[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			prices[k] = rightPart[j];
			j++;
			k++;
		}
	}
}
