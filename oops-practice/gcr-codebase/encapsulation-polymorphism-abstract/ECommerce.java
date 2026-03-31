import java.util.ArrayList;
import java.util.List;

interface Taxable {
	double calculateTax();

	String getTaxDetails();
}

abstract class Product {
	private int productId;
	private String name;
	private double price;

	Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	double getPrice() {
		return price;
	}

	abstract double calculateDiscount();

	void printFinalPrice() {
		double tax = 0;
		if (this instanceof Taxable) {
			tax = ((Taxable) this).calculateTax();
		}
		double finalPrice = price + tax - calculateDiscount();
		System.out.println(name + " Final Price: " + finalPrice);
	}
}

class Electronics extends Product implements Taxable {
	Electronics(int id, String name, double price) {
		super(id, name, price);
	}

	double calculateDiscount() {
		return getPrice() * 0.1;
	}

	public double calculateTax() {
		return getPrice() * 0.18;
	}

	public String getTaxDetails() {
		return "GST 18%";
	}
}

class Clothing extends Product {
	Clothing(int id, String name, double price) {
		super(id, name, price);
	}

	double calculateDiscount() {
		return getPrice() * 0.2;
	}
}

class Groceries extends Product {
	Groceries(int id, String name, double price) {
		super(id, name, price);
	}

	double calculateDiscount() {
		return getPrice() * 0.05;
	}
}

public class ECommerce {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

		products.add(new Electronics(1, "Laptop", 60000));
		products.add(new Clothing(2, "Shirt", 2000));
		products.add(new Groceries(3, "Rice", 1000));

		for (Product p : products) {
			p.printFinalPrice();
		}
	}
}
