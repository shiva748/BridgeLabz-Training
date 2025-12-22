import java.util.Scanner;

public class CompareStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a word: ");
		String word1 = scanner.next();
		System.out.print("Please enter second word: ");
		String word2 = scanner.next();
		System.out.printf("Is %s equals %s: %s%n",word1, word2, word1.equals(word2)?"yes":"no");
		boolean equal = true;
		if(word1.length() != word2.length()) {
			equal = false;
		}else {
			for(int i = 0; i < word1.length(); i++) {
				if(word1.charAt(i) != word2.charAt(i)) {
					equal = false;
					break;
				}
			}
		}
		System.out.printf("Is %s equals %s: %s comparison using charAt", word1, word2,equal?"yes":"no");
		scanner.close();
		
	}

}
