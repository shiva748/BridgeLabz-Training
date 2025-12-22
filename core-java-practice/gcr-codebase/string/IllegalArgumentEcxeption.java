import java.util.Scanner;

public class IllegalArgumentEcxeption {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter a text: ");
			String text = scanner.nextLine();
			System.out.println(text.substring(5, 2));
			scanner.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
