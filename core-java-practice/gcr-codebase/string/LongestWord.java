import java.util.Scanner;

public class LongestWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a sentence: ");
		String text = scanner.nextLine();
		String[] words = text.split(" ");
		String longest = "";

		for (String word : words) {
		    if (word.length() > longest.length()) {
		        longest = word;
		    }
		}
		System.out.printf("%s is the longest word", longest);
		scanner.close();
	}

}
