import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
	private String customer;
	private double amount;

	Order(String customer, double amount) {
		this.customer = customer;
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public double getAmount() {
		return amount;
	}
}

public class OrderRevenue {
	public static void main(String[] args) {

		List<Order> orders = Arrays.asList(new Order("Shiva", 1200.50), new Order("Anu", 800.00),
				new Order("Shiva", 650.75), new Order("Anu", 300.25), new Order("Ravi", 1500.00));
		Map<String, Double> revenueByCustomer = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getAmount)));

		System.out.println(revenueByCustomer);
	}
}
