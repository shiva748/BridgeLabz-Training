import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {

    private String name;
    private int price;

    public WarehouseItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void display();
}

class Electronics extends WarehouseItem {

    public Electronics(String name, int price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.printf(
                "Electronic item [%s] costs INR %d%n",
                getName(),
                getPrice()
        );
    }
}

class Groceries extends WarehouseItem {

    public Groceries(String name, int price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.printf(
                "Grocery item [%s] costs INR %d%n",
                getName(),
                getPrice()
        );
    }
}

class Furniture extends WarehouseItem {

    public Furniture(String name, int price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.printf(
                "Furniture item [%s] costs INR %d%n",
                getName(),
                getPrice()
        );
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

class WarehouseUtils {

    public static void displayAll(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

public class SmartWarehouseManagement {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 75000));
        electronicsStorage.addItem(new Electronics("Mobile", 30000));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 1200));
        groceryStorage.addItem(new Groceries("Milk", 60));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 2500));
        furnitureStorage.addItem(new Furniture("Table", 8000));

        System.out.println("---- Electronics ----");
        WarehouseUtils.displayAll(electronicsStorage.getAllItems());

        System.out.println("---- Groceries ----");
        WarehouseUtils.displayAll(groceryStorage.getAllItems());

        System.out.println("---- Furniture ----");
        WarehouseUtils.displayAll(furnitureStorage.getAllItems());
    }
}
