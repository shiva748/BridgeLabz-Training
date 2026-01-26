import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount + "%";
    }
}

public class CustomSortingEcommerce {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Phone", 30000, 4.7, 20));
        products.add(new Product("Headphones", 3000, 4.2, 30));
        products.add(new Product("Watch", 5000, 4.0, 15));

        System.out.println("\nOriginal List:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Integer.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}
