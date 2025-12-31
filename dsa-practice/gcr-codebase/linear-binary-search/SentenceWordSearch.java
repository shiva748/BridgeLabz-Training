import java.util.Scanner;

public class SentenceWordSearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of sentences: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		String[] sentences = new String[size];

		System.out.println("Enter the sentences:");
		for (int i = 0; i < size; i++) {
			sentences[i] = scanner.nextLine();
		}

		System.out.print("Enter the word to search: ");
		String word = scanner.nextLine();

		String result = findSentenceContainingWord(sentences, word);

		if (result.equals("Not Found")) {
			System.out.println("Word not found in any sentence");
		} else {
			System.out.println("Word found in sentence:");
			System.out.println(result);
		}

		scanner.close();
	}

	public static String findSentenceContainingWord(String[] arr, String word) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(word)) {
				return arr[i];
			}
		}
		return "Not Found";
	}
}
