
import java.util.LinkedList;
import java.util.Queue;

class Vehicle {

    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

class Roundabout {

    private Vehicle head = null;

    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);

        if (head == null) {
            head = newVehicle;
            head.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newVehicle;
            newVehicle.next = head;
        }
    }
 
    public void removeVehicle(String number) {
        if (head == null) {
            System.out.println("Roundabout empty.");
            return;
        }

        Vehicle curr = head, prev = null;

        do {
            if (curr.number.equals(number)) {
                if (curr == head) {
                    Vehicle last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Vehicle removed: " + number);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Vehicle not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}

class WaitingQueue {

    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    WaitingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(String vehicle) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Cannot add " + vehicle);
            return;
        }
        queue.add(vehicle);
        System.out.println(vehicle + " added to waiting queue.");
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }
}

public class TrafficManager {

    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        WaitingQueue queue = new WaitingQueue(3);

        queue.enqueue("KA01");
        queue.enqueue("KA02");
        queue.enqueue("KA03");
        queue.enqueue("KA04"); // Overflow

        String vehicle = queue.dequeue();
        if (vehicle != null) {
            roundabout.addVehicle(vehicle);
        }

        roundabout.addVehicle("KA05");
        roundabout.display();

        roundabout.removeVehicle("KA01");
        roundabout.display();
    }
}
