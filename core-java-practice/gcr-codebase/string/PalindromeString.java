import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		boolean ispalindrome = true;
		int left = 0, right = text.length()-1;
		while(left <= right) {
			if(text.charAt(right--) != text.charAt(left++)) {
				ispalindrome = false;
				break;
			}
		}
		System.out.printf("%s %s palindrome", text, ispalindrome?"is":"is not");
		scanner.close();
	}

}
