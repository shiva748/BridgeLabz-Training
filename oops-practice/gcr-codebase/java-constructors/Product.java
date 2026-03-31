
public class Product {

	String productName;
	double price;

	static int totalProduct;

	public void displayProductDetails() {
		System.out.printf("Product name is %s and it's priced at %.2f", productName, price);
	}

	public static void displayTotalProduct() {
		System.out.printf("ther are total %d unit avilable", totalProduct);
	}

}
