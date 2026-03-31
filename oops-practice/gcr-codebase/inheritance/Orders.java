class Order {
	int orderId;
	String orderDate;

	public String getOrderStatus() {
		return "Order Placed";
	}
}

class ShippedOrder extends Order {
	String trackingNumber;

	@Override
	public String getOrderStatus() {
		return "Order Shipped";
	}
}

class DeliveredOrder extends ShippedOrder {
	String deliveryDate;

	@Override
	public String getOrderStatus() {
		return "Order Delivered";
	}
}

public class Orders {
	public static void main(String[] args) {
		Order order1 = new Order();
		Order order2 = new ShippedOrder();
		Order order3 = new DeliveredOrder();

		System.out.println(order1.getOrderStatus());
		System.out.println(order2.getOrderStatus());
		System.out.println(order3.getOrderStatus());
	}
}
