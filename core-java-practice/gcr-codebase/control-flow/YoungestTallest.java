import java.util.Scanner;

public class YoungestTallest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] names = { "amar", "akbar", "anthony" };
		int[] age = new int[3];
		int[] height = new int[3];

		for (int i = 0; i < 3; i++) {
			System.out.printf("Enter age of %s :- ", names[i]);
			age[i] = sc.nextInt();

			System.out.printf("Enter height of %s :- ", names[i]);
			height[i] = sc.nextInt();
		}

		int young = 0;
		int tall = 0;

		for (int i = 1; i < 3; i++) {
			if (age[i] < age[young]) {
				young = i;
			}
			if (height[i] > height[tall]) {
				tall = i;
			}
		}

		System.out.println("Youngest person: " + names[young]);
		System.out.println("Tallest person: " + names[tall]);

		sc.close();
	}
}
