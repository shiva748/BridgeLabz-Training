import java.util.Scanner;

public class PalindromeChecker {

	public static boolean isPalindrome(String s) {
		String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String rev = new StringBuilder(cleaned).reverse().toString();
		return cleaned.equals(rev);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a string: ");
		String s = scanner.nextLine();
		System.out.println(s + " is " + (isPalindrome(s) ? "a palindrome" : "not a palindrome"));
		scanner.close();
	}

}