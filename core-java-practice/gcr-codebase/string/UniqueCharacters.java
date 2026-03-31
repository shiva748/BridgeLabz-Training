import java.util.Scanner;

public class UniqueCharacters {

	public static int stringLength(String a) {
		int len = 0;
		try {
			while (true) {
				a.charAt(len);
				len++;
			}
		} catch (Exception e) {
			// calculated
		}
		return len;
	}

	public static char[] uniqueCharacters(String text) {
		int len = stringLength(text);
		char[] temp = new char[len];
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c = text.charAt(i);
			boolean unique = true;
			for (int j = 0; j < i; j++) {
				if (text.charAt(j) == c) {
					unique = false;
					break;
				}
			}
			if (unique) {
				temp[count++] = c;
			}
		}
		char[] result = new char[count];
		for (int i = 0; i < count; i++)
			result[i] = temp[i];
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		char[] uniques = uniqueCharacters(text);
		System.out.print("Unique characters: ");
		for (char c : uniques) {
			System.out.print(c + " ");
		}
		System.out.println();
		scanner.close();
	}

}