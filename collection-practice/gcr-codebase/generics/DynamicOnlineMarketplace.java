import java.util.ArrayList;
import java.util.List;


abstract class ProductCategory {

    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends ProductCategory {

    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {

    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {

    public GadgetCategory() {
        super("Gadgets");
    }
}


abstract class Product<T extends ProductCategory> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void display();
}


class Book extends Product<BookCategory> {

    public Book(String name, double price) {
        super(name, price, new BookCategory());
    }

    @Override
    public void display() {
        System.out.printf(
                "Book [%s] in category [%s] costs INR %.2f%n",
                getName(),
                getCategory().getName(),
                getPrice()
        );
    }
}

class Clothing extends Product<ClothingCategory> {

    public Clothing(String name, double price) {
        super(name, price, new ClothingCategory());
    }

    @Override
    public void display() {
        System.out.printf(
                "Clothing item [%s] in category [%s] costs INR %.2f%n",
                getName(),
                getCategory().getName(),
                getPrice()
        );
    }
}

class Gadget extends Product<GadgetCategory> {

    public Gadget(String name, double price) {
        super(name, price, new GadgetCategory());
    }

    @Override
    public void display() {
        System.out.printf(
                "Gadget [%s] in category [%s] costs INR %.2f%n",
                getName(),
                getCategory().getName(),
                getPrice()
        );
    }
}


class ProductCatalog<T extends Product<?>> {

    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getAllProducts() {
        return products;
    }
}


class MarketplaceUtils {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice()
                - (product.getPrice() * percentage / 100);

        product.setPrice(discountedPrice);
    }

    public static void displayAll(List<? extends Product<?>> products) {
        for (Product<?> product : products) {
            product.display();
        }
    }
}


public class DynamicOnlineMarketplace {

    public static void main(String[] args) {

        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new Book("Clean Code", 899));
        bookCatalog.addProduct(new Book("Effective Java", 1050));

        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new Clothing("T-Shirt", 799));
        clothingCatalog.addProduct(new Clothing("Jeans", 2199));

        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new Gadget("Smartphone", 45000));
        gadgetCatalog.addProduct(new Gadget("Smartwatch", 12999));

        System.out.println("---- Books ----");
        MarketplaceUtils.displayAll(bookCatalog.getAllProducts());

        System.out.println("---- Clothing ----");
        MarketplaceUtils.displayAll(clothingCatalog.getAllProducts());

        System.out.println("---- Gadgets ----");
        MarketplaceUtils.displayAll(gadgetCatalog.getAllProducts());

        System.out.println("---- Applying Discount ----");
        MarketplaceUtils.applyDiscount(bookCatalog.getAllProducts().get(0), 10);
        MarketplaceUtils.applyDiscount(gadgetCatalog.getAllProducts().get(1), 15);

        System.out.println("---- After Discount ----");
        MarketplaceUtils.displayAll(bookCatalog.getAllProducts());
        MarketplaceUtils.displayAll(gadgetCatalog.getAllProducts());
    }
}
