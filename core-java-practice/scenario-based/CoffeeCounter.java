import java.util.HashMap;
import java.util.Scanner;

public class CoffeeCounter {
	public static void printInstruction() {
		System.out.println("================================");
		System.out.println("    Welcome to Our Cafe");
		System.out.println("================================");
		System.out.println("Type ORDER to order a coffee");
		System.out.println("Type EXIT  to close the cafe");
		System.out.println("================================");
	}

	public static void main(String[] args) {
		HashMap<String, Integer> menu = new HashMap<String, Integer>();
		menu.put("Espresso", 80);
		menu.put("Americano", 100);
		menu.put("Cappuccino", 120);
		menu.put("Latte", 130);
		menu.put("Mocha", 150);
		menu.put("FlatWhite", 140);
		menu.put("Macchiato", 110);
		menu.put("ColdCoffee", 160);
		Scanner scanner = new Scanner(System.in);
		printInstruction();
		while (true) {
			String input = scanner.next().toUpperCase();
			switch (input) {
			case "ORDER": {
				System.out.print("Please enter coffee you would like to have:- ");
				String name = scanner.next();
				if (!menu.containsKey(name)) {
					System.out.println("Invalid coffee selection please start again.");
					break;
				} else {
					System.out.print("Please enter Number of cups:- ");
					int cups = scanner.nextInt();
					System.out.printf("Final bill of %d %s is INR %.2f%n", cups, name, cups * menu.get(name) * 1.05);
				}
			}
			case "EXIT": {
				System.out.println("Thankyou for visiting our cafe");
				return;
			}
			default:
				System.out.println("Invalid input.");
			}

		}
	}
}