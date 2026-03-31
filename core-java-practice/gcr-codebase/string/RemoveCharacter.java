import java.util.Scanner;

public class RemoveCharacter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String text = scanner.nextLine();
		char ch = scanner.next().charAt(0);
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ch) {
				result.append(text.charAt(i));
			}
		}

		System.out.printf("modified string: %s", result.toString());
		scanner.close();

	}

}
