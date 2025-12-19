import java.util.Scanner;

public class CanVote {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter you age: -");
		int age = scanner.nextInt();
		System.out.printf(age < 18?"The person age is %d and cannot vote.":"The person age is %d and can vote", age);
		scanner.close();
	}

}
