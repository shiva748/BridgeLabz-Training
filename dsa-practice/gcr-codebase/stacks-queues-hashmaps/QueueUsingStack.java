import java.util.ArrayList;
import java.util.List;

interface QueueOperations {
	void enqueue(int data);

	int dequeue();

	boolean isEmpty();
}

class Stack {
	private List<Integer> elements = new ArrayList<>();

	void push(int data) {
		elements.add(data);
	}

	int pop() {
		if (elements.isEmpty()) {
			return -1;
		}
		return elements.remove(elements.size() - 1);
	}

	boolean isEmpty() {
		return elements.isEmpty();
	}
}

class QueueUsingStacks implements QueueOperations {
	private Stack stack1 = new Stack();
	private Stack stack2 = new Stack();

	public void enqueue(int data) {
		stack1.push(data);
	}

	public int dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}

public class QueueUsingStack {
	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		queue.enqueue(40);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
