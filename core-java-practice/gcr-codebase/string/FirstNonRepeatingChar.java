import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static char firstNonRepeatingChar(String text) {
		int[] freq = new int[256];
		int len = text.length();
		for (int i = 0; i < len; i++) {
			freq[(int) text.charAt(i)]++;
		}
		for (int i = 0; i < len; i++) {
			if (freq[(int) text.charAt(i)] == 1)
				return text.charAt(i);
		}
		return '\0';
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		char result = firstNonRepeatingChar(text);
		if (result == '\0')
			System.out.println("No non-repeating character found");
		else
			System.out.printf("First non-repeating character: %s\n", result);
		scanner.close();
	}

}