import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

	public static boolean isAnagram(String firstString, String secondString) {

		if (firstString.length() != secondString.length()) {
			return false;
		}

		char[] arr1 = firstString.toCharArray();
		char[] arr2 = secondString.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter first text: ");
		String firstString = scanner.nextLine();
		System.out.print("Please enter second text: ");
		String secondString = scanner.nextLine();

		System.out.printf("%s is %s anagram of %s", firstString, isAnagram(firstString, secondString) ? "a" : "not a",
				secondString);
		scanner.close();
	}
}
