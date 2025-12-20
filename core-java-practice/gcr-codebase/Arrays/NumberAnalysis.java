import java.util.Arrays;
import java.util.Scanner;

public class NumberAnalysis {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter 5 numbers: ");
		int nums[] = new int[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scanner.nextInt();
		}
		Arrays.stream(nums).forEach((e) -> {
			if (e < 0) {
				System.out.println("Negative");
			} else if (e == 0) {
				System.out.println("Zero");
			} else {
				System.out.println(e % 2 == 0 ? "Even" : "Odd");
			}
		});
		System.out.printf("%d is %s %d", nums[0],
				nums[0] > nums[4] ? "greater then" : nums[0] == nums[4] ? "equal to" : "less then", nums[4]);
		scanner.close();
	}

}
