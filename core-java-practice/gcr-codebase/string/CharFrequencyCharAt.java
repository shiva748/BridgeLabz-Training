import java.util.ArrayList;
import java.util.Scanner;

public class CharFrequencyCharAt {

	public static String[][] frequencyUsingCharAt(String text) {
		int[] freq = new int[256];
		int len = text.length();
		for (int i = 0; i < len; i++) {
			freq[(int) text.charAt(i)]++;
		}
		ArrayList<String[]> rows = new ArrayList<>();
		for (int i = 0; i < 256; i++) {
			if (freq[i] > 0) {
				rows.add(new String[] { Character.toString((char) i), Integer.toString(freq[i]) });
			}
		}
		String[][] result = new String[rows.size()][];
		rows.toArray(result);
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		String[][] freqTable = frequencyUsingCharAt(text);
		System.out.println("Character -> Frequency");
		for (String[] row : freqTable) {
			System.out.printf("%s -> %s\n", row[0], row[1]);
		}
		scanner.close();
	}

}