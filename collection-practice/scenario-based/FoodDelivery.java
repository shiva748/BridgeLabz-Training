import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FoodDelivery {
    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent(1, "Rahul"));
        service.addAgent(new Agent(2, "Ankit"));

        service.placeOrder(new Order(101, "CUST1", "Pizza"));
        service.placeOrder(new Order(102, "CUST2", "Burger"));
        service.placeOrder(new Order(103, "CUST3", "Biryani"));

        service.assignOrders();

        service.viewActiveDeliveries();

        service.cancelOrder(101);

        service.viewActiveDeliveries();
    }
}

class DeliveryService {

    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    private Map<Integer, Agent> activeDeliveries = new HashMap<>();

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void placeOrder(Order order) {
        orderQueue.offer(order);
    }

    public void assignOrders() {
        while (!orderQueue.isEmpty()) {
            Agent freeAgent = getAvailableAgent();

            if (freeAgent == null) {
                throw new NoAgentAvailableException("No delivery agent available");
            }

            Order order = orderQueue.poll();
            freeAgent.setAvailable(false);
            freeAgent.setCurrentOrder(order);

            activeDeliveries.put(order.getOrderId(), freeAgent);

            System.out.println("Order " + order.getOrderId()
                    + " assigned to agent " + freeAgent.getName());
        }
    }

    public void cancelOrder(int orderId) {
        Agent agent = activeDeliveries.remove(orderId);
        if (agent != null) {
            agent.setAvailable(true);
            agent.setCurrentOrder(null);
            System.out.println("Order " + orderId + " cancelled");
        }
    }

    public void viewActiveDeliveries() {
        System.out.println("\nActive Deliveries:");
        for (Map.Entry<Integer, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println("Order ID: " + entry.getKey()
                    + " -> Agent: " + entry.getValue().getName());
        }
    }

    private Agent getAvailableAgent() {
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                return agent;
            }
        }
        return null;
    }
}

class Agent {
    private Integer agentId;
    private String name;
    private boolean available = true;
    private Order currentOrder;

    public Agent(Integer agentId, String name) {
        this.agentId = agentId;
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public String getName() {
        return name;
    }
}

class Order {
    private Integer orderId;
    private String customerId;
    private String orderItem;

    public Order(Integer orderId, String customerId, String orderItem) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItem = orderItem;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderItem() {
        return orderItem;
    }
}

class NoAgentAvailableException extends RuntimeException {
    public NoAgentAvailableException(String message) {
        super(message);
    }
}
