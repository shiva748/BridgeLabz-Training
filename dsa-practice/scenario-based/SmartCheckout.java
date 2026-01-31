import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Customer {
    String name;
    List<String> items;

    Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}

public class SmartCheckout {

    private Queue<Customer> customerQueue = new LinkedList<>();
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> stockMap = new HashMap<>();

    public SmartCheckout() {
        priceMap.put("Milk", 40.0);
        priceMap.put("Bread", 30.0);
        priceMap.put("Eggs", 6.0);
        priceMap.put("Rice", 60.0);

        stockMap.put("Milk", 10);
        stockMap.put("Bread", 15);
        stockMap.put("Eggs", 100);
        stockMap.put("Rice", 20);
    }

    public void addCustomer(Customer customer) {
        customerQueue.offer(customer);
    }

    public void processNextCustomer() {
        Customer customer = customerQueue.poll();
        if (customer == null) {
            System.out.println("No customers in queue");
            return;
        }

        double total = 0;

        for (String item : customer.items) {
            if (stockMap.get(item) > 0) {
                total += priceMap.get(item);
                stockMap.put(item, stockMap.get(item) - 1);
            } else {
                System.out.println(item + " is out of stock");
            }
        }

        System.out.println(customer.name + " bill amount: " + total);
    }

    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        checkout.addCustomer(new Customer("Shiva", Arrays.asList("Milk", "Bread")));
        checkout.addCustomer(new Customer("Anu", Arrays.asList("Rice", "Eggs", "Eggs")));
        checkout.addCustomer(new Customer("Ravi", Arrays.asList("Milk", "Milk", "Bread")));

        checkout.processNextCustomer();
        checkout.processNextCustomer();
        checkout.processNextCustomer();
    }
}
