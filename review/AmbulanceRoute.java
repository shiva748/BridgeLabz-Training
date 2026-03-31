import java.util.Scanner;

public class AmbulanceRoute {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter number of stations: ");
		int n = scanner.nextInt();
		CircularList route = new CircularList();
		System.out.print("Please enter name's and avilability: ");
		for (int i = 0; i < n; i++) {
			route.insert(new Node(scanner.next(), scanner.nextBoolean()));
		}
		System.out.println(route.closestAvilable(route.head));
	}

}

class Node {
	String name;

	boolean isAvilable;

	Node next;

	public Node(String name, boolean isAvilable) {
		this.name = name;
		this.isAvilable = isAvilable;
	}
}

class CircularList {

	Node head;

	Node tail;

	void insert(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		tail.next = head;
	}

	int closestAvilable(Node head) {
		if (head.isAvilable) {
			return 0;
		}
		Node temp = head.next;
		int c = 1;
		while (!temp.isAvilable) {
			if (head == temp) {
				return -1;
			}
			temp = temp.next;
			c++;
		}
		return c;
	}
}