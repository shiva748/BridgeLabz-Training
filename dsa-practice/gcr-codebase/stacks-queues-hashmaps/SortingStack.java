import java.util.ArrayList;
import java.util.List;

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

	int peek() {
		if (elements.isEmpty()) {
			return -1;
		}
		return elements.get(elements.size() - 1);
	}

	boolean isEmpty() {
		return elements.isEmpty();
	}

	void display() {
		System.out.println(elements);
	}
}

class StackSorter {

	void sortStack(Stack stack) {
		if (stack.isEmpty()) {
			return;
		}

		int temp = stack.pop();
		sortStack(stack);
		insertInSortedOrder(stack, temp);
	}

	private void insertInSortedOrder(Stack stack, int value) {
		if (stack.isEmpty() || stack.peek() <= value) {
			stack.push(value);
			return;
		}

		int temp = stack.pop();
		insertInSortedOrder(stack, value);
		stack.push(temp);
	}
}

public class SortingStack {
	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(30);
		stack.push(10);
		stack.push(50);
		stack.push(20);

		System.out.print("Before Sorting: ");
		stack.display();

		StackSorter sorter = new StackSorter();
		sorter.sortStack(stack);

		System.out.print("After Sorting: ");
		stack.display();
	}
}
