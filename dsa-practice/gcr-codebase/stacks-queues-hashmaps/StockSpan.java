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
}

class StockSpanCalculator {

	int[] calculateSpan(int[] prices) {
		int n = prices.length;
		int[] span = new int[n];
		Stack stack = new Stack();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - stack.peek();
			}

			stack.push(i);
		}
		return span;
	}
}

public class StockSpan {
	public static void main(String[] args) {
		int[] prices = { 100, 80, 60, 70, 60, 75, 85 };

		StockSpanCalculator calculator = new StockSpanCalculator();
		int[] result = calculator.calculateSpan(prices);

		for (int span : result) {
			System.out.print(span + " ");
		}
	}
}
