import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingComparison {

	public static void main(String[] args) {
		int[] originalArray = { 73, 12, 45, 33, 90, 23, 17, 60, 5, 79, 94, 20, 70, 11, 41, 43, 10, 32, 4, 96, 24, 30,
				21, 56, 9, 2, 88, 27, 59, 61, 6, 99, 38, 25, 77, 46, 1, 84, 53, 14, 67, 19, 36, 82, 7, 48, 66, 97, 35,
				100 };

		benchmark("Bubble Sort", originalArray, SortingComparison::bubbleSort);
		benchmark("Merge Sort", originalArray, SortingComparison::mergeSort);
		benchmark("Quick Sort", originalArray, SortingComparison::quickSort);
	}

	private static void benchmark(String name, int[] original, SortAlgorithm algorithm) {
		int[] arrayCopy = Arrays.copyOf(original, original.length);
		long startTime = System.nanoTime();
		algorithm.sort(arrayCopy);
		long endTime = System.nanoTime();
		System.out.println(name + " time: " + (endTime - startTime) + " ns");
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	private static void merge(int[] array, int start, int mid, int end) {
		List<Integer> temp = new ArrayList<>();
		int left = start, right = mid + 1;

		while (left <= mid && right <= end) {
			if (array[left] <= array[right]) {
				temp.add(array[left++]);
			} else {
				temp.add(array[right++]);
			}
		}

		while (left <= mid) {
			temp.add(array[left++]);
		}

		while (right <= end) {
			temp.add(array[right++]);
		}

		for (int i = 0; i < temp.size(); i++) {
			array[start + i] = temp.get(i);
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	@FunctionalInterface
	interface SortAlgorithm {
		void sort(int[] array);
	}
}
