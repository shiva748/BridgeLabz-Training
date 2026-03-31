import java.util.Scanner;

public class FrequencyUsingUnique {

	public static int[] frequency(String text) {
		int[] freq = new int[256];
		for (int i = 0; i < text.length(); i++) {
			freq[(int) text.charAt(i)]++;
		}
		return freq;
	}

	public static char[] uniqueCharacters(String text) {
		int len = text.length();
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

	public static String[][] freqUsingUnique(String text) {
		int[] freq = frequency(text);
		char[] uniques = uniqueCharacters(text);
		String[][] table = new String[uniques.length][2];
		for (int i = 0; i < uniques.length; i++) {
			table[i][0] = Character.toString(uniques[i]);
			table[i][1] = Integer.toString(freq[(int) uniques[i]]);
		}
		return table;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		String[][] table = freqUsingUnique(text);
		System.out.println("Character -> Frequency (using unique characters)");
		for (String[] row : table) {
			System.out.printf("%s -> %s\n", row[0], row[1]);
		}
		scanner.close();
	}

}