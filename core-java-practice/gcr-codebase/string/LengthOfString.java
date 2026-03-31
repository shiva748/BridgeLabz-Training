import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class LengthOfString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		Function<String, Integer> length = (a)->{
			int len = 0;
			try {
				while (true) {
					a.charAt(len);
					len++;
				}
			} catch (Exception e) {
				System.out.println("String length calculated");
			}
			return len;
		};
		int calculatedlength = length.apply(text);
		int methodlength = text.length();
		System.out.printf("calculated length %d and method length %d", calculatedlength, methodlength);
		scanner.close();
	}

}
