import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	private static int generateGuess(int low, int high) {
		Random r = new Random();
		return low + r.nextInt(high - low + 1);
	}
	
	private static String getFeedback(Scanner scanner) {
		System.out.print("enter feedback (high/low/correct): ");
		return scanner.nextLine().trim().toLowerCase();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Think of a number between 1 and 100 and I will try to guess it.");
		int low = 1, high = 100;
		while(low <= high) {
			int guess = generateGuess(low, high);
			System.out.println("my guess is: " + guess);
			String fb = getFeedback(scanner);
			if(fb.equals("correct")){
				System.out.println("yay! I guessed the number.");
				break;
			}else if(fb.equals("high")){
				high = guess - 1;
			}else if(fb.equals("low")){
				low = guess + 1;
			}else{
				System.out.println("please enter only: high, low or correct");
			}
			if(low > high) {
				System.out.println("there seems to be inconsistent feedback. exiting.");
				break;
			}
		}
		scanner.close();
	}

}