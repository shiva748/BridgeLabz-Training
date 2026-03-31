import java.util.Scanner;

public class ToggleCase {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String text = scanner.nextLine();
		StringBuilder result = new StringBuilder();

	    for (int i = 0; i < text.length(); i++) {
	        char ch = text.charAt(i);

	        if (ch >= 'A' && ch <= 'Z') {
	            result.append((char) (ch + 32));
	        } else if (ch >= 'a' && ch <= 'z') {
	            result.append((char) (ch - 32));
	        } else {
	            result.append(ch);
	        }
	    }
	    System.out.printf("%s inverted string is %s", text, result.toString());
	    scanner.close();
	}

}
