import java.util.Scanner;

public class ProductPriceSorter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of products: ");
		int total = sc.nextInt();

		int[] priceList = new int[total];

		System.out.println("Enter product prices:");
		for (int i = 0; i < total; i++) {
			priceList[i] = sc.nextInt();
		}

		quickSortPrices(priceList, 0, total - 1);

		System.out.println("Product prices after sorting:");
		for (int value : priceList) {
			System.out.print(value + " ");
		}

		sc.close();
	}

	private static void quickSortPrices(int[] prices, int low, int high) {

		if (low < high) {
			int pivotIndex = partitionArray(prices, low, high);

			quickSortPrices(prices, low, pivotIndex - 1);
			quickSortPrices(prices, pivotIndex + 1, high);
		}
	}

	private static int partitionArray(int[] prices, int start, int end) {

		int pivotValue = prices[end];
		int pointer = start - 1;

		for (int i = start; i < end; i++) {
			if (prices[i] < pivotValue) {
				pointer++;
				int temp = prices[pointer];
				prices[pointer] = prices[i];
				prices[i] = temp;
			}
		}

		int temp = prices[pointer + 1];
		prices[pointer + 1] = prices[end];
		prices[end] = temp;

		return pointer + 1;
	}
}
