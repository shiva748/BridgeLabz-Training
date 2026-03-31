import java.util.Scanner;

public class CharArrayComparison {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a String: ");
		String string = scanner.nextLine();
		char chararray1[] = string.toCharArray();
		char chararray2[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			chararray2[i] = string.charAt(i);
		}
		for(int i = 0; i < chararray1.length; i++) {
			System.out.printf("'%c' = '%c'%n", chararray1[i], chararray2[i]);
		}
		scanner.close();
	}

}
