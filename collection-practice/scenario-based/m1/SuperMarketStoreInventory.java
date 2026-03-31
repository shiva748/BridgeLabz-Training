import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
	String name;
	double price;
	int quantity;

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	abstract void displayDetails();
}

class Electronics extends Product {
	int warranty;

	public Electronics(String name, double price, int quantity, int warranty) {
		super(name, price, quantity);
		this.warranty = warranty;
	}

	@Override
	void displayDetails() {
		System.out.println(this.name + " - Price: " + this.price + ", Quantity: " + this.quantity + ", Warranty: "
				+ this.warranty + " months");
	}
}

class Clothing extends Product {
	String size;

	public Clothing(String name, double price, int quantity, String size) {
		super(name, price, quantity);
		this.size = size;
	}

	@Override
	void displayDetails() {
		System.out.println(
				this.name + " - Price: " + this.price + ", Quantity: " + this.quantity + ", Size: " + this.size);
	}

}

public class SuperMarketStoreInventory {
	static List<Product> inventory = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			add(input);
		}
		System.out.println();
		display(inventory);
		System.out.println();
		System.out.println("Total Inventory Value: " + total(inventory));
	}

	private static void add(String input) {
		String[] parts = input.split(", ");
		String choice = parts[0];
		switch (choice) {
		case "Electronics":
			Electronics e = new Electronics(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]));
			inventory.add(e);
			System.out.println("Product added to inventory: " + parts[1]);
			break;
		case "Clothing":
			Clothing c = new Clothing(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), parts[4]);
			inventory.add(c);
			System.out.println("Product added to inventory: " + parts[1]);
			break;
		}

	}

	private static double total(List<Product> inventory) {
		double total = 0;
		for (Product p : inventory) {
			total += p.price * p.quantity;
		}
		return total;

	}

	private static void display(List<Product> inventory) {
		System.out.println("Inventory: ");
		for (Product p : inventory) {
			p.displayDetails();
		}
	}
}
