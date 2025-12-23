import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();
		StringBuilder reverse = new StringBuilder();
		for(int i = text.length()-1; i >=0; i--) {
			reverse.append(text.charAt(i));
		}
		System.out.printf("reverse of %s is %s", text, reverse.toString());
		scanner.close();
	}

}
