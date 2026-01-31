import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Order {
    int orderId;
    String location;

    Order(int orderId, String location) {
        this.orderId = orderId;
        this.location = location;
    }
}

class Agent {
    int agentId;
    String location;
    boolean available = true;

    Agent(int agentId, String location) {
        this.agentId = agentId;
        this.location = location;
    }
}

class NoAgentAvailableException extends Exception {
    NoAgentAvailableException(String message) {
        super(message);
    }
}

class DeliveryService {

    Queue<Order> orderQueue = new LinkedList<>();
    List<Agent> agents = new ArrayList<>();
    Map<Integer, Integer> activeDeliveries = new HashMap<>();

    void addOrder(Order order) {
        orderQueue.offer(order);
    }

    void addAgent(Agent agent) {
        agents.add(agent);
    }

    void assignOrder() throws NoAgentAvailableException {
        Order order = orderQueue.poll();
        if (order == null) return;

        Agent selectedAgent = null;
        for (Agent agent : agents) {
            if (agent.available) {
                selectedAgent = agent;
                break;
            }
        }

        if (selectedAgent == null) {
            orderQueue.offer(order);
            throw new NoAgentAvailableException("No delivery agent available");
        }

        selectedAgent.available = false;
        activeDeliveries.put(order.orderId, selectedAgent.agentId);

        System.out.println("Order " + order.orderId +
                " assigned to Agent " + selectedAgent.agentId);
    }

    void cancelOrder(int orderId) {
        Integer agentId = activeDeliveries.remove(orderId);
        if (agentId != null) {
            for (Agent agent : agents) {
                if (agent.agentId == agentId) {
                    agent.available = true;
                    break;
                }
            }
            System.out.println("Order " + orderId + " cancelled");
        }
    }

    void viewActiveDeliveries() {
        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries");
            return;
        }
        activeDeliveries.forEach(
                (orderId, agentId) ->
                        System.out.println("Order " + orderId + " -> Agent " + agentId)
        );
    }
}

public class FoodDeliveryRouting {
    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent(1, "Zone A"));
        service.addAgent(new Agent(2, "Zone B"));

        service.addOrder(new Order(101, "Zone A"));
        service.addOrder(new Order(102, "Zone B"));
        service.addOrder(new Order(103, "Zone C"));

        try {
            service.assignOrder();
            service.assignOrder();
            service.assignOrder();
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewActiveDeliveries();

        service.cancelOrder(101);

        try {
            service.assignOrder();
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewActiveDeliveries();
    }
}
