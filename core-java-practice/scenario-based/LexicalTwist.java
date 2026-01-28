import java.util.Scanner;

public class LexicalTwist {
	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static String transform(String reverse) {
		StringBuilder reversed = new StringBuilder();
		int l = reverse.length();
		for (int i = l - 1; i >= 0; i--) {
			char cur = reverse.charAt(i);
			char lower = cur < 97 ? (char) (cur + ('a' - 'A')) : cur;
			char finalchar = isVowel(lower) ? '@' : lower;
			reversed.append(finalchar);
		}
		return reversed.toString();
	}

	public static boolean isReversed(String first, String second) {
		if (first.length() != second.length()) {
			return false;
		}
		int l = first.length();
		for (int i = 0; i < l; i++) {
			char a = first.charAt(i);
			char b = second.charAt(l - i - 1);

			if (a != b && Math.abs(a - b) != Math.abs('a' - 'A')) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the first word\n");
		String firstWord = scanner.nextLine();

		if (firstWord.contains(" ")) {
			System.out.print(firstWord + " is an invalid word");
			return;
		}

		System.out.print("Enter the second word\n");
		String secondWord = scanner.nextLine();

		if (secondWord.contains(" ")) {
			System.out.print(secondWord + " is an invalid word");
			return;
		}

		if (isReversed(firstWord, secondWord)) {
			firstWord = transform(firstWord);
			System.out.print(firstWord);
		} else {

			String combined = (firstWord + secondWord).toUpperCase();

			int vowels = 0;
			int consonants = 0;

			for (int i = 0; i < combined.length(); i++) {
				char c = combined.charAt(i);
				char lower = (char) (c + ('a' - 'A'));
				if (isVowel(lower))
					vowels++;
				else
					consonants++;
			}

			if (vowels > consonants) {
				String result = "";
				for (int i = 0; i < combined.length(); i++) {
					char c = combined.charAt(i);
					char lower = (char) (c + ('a' - 'A'));
					if (isVowel(lower) && result.indexOf(c) == -1) {
						result += c;
					}
					if (result.length() == 2)
						break;
				}
				System.out.print(result);
			} else if (consonants > vowels) {
				String result = "";
				for (int i = 0; i < combined.length(); i++) {
					char c = combined.charAt(i);
					char lower = (char) (c + ('a' - 'A'));
					if (!isVowel(lower) && result.indexOf(c) == -1) {
						result += c;
					}
					if (result.length() == 2)
						break;
				}
				System.out.print(result);
			} else {
				System.out.print("Vowels and consonants are equal");
			}
		}

		scanner.close();
	}
}
