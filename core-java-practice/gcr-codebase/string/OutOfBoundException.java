import java.util.Scanner;

public class OutOfBoundException {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("please enter a string: ");
			String text =	scanner.nextLine();
			for(int i = 0; i < text.length()+1; i++) {
				System.out.print(text.charAt(i));
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("\n"+e.getMessage());
		}
	}

}
