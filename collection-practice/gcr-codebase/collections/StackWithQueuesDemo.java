import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {

    private Queue<Integer> primary = new LinkedList<>();
    private Queue<Integer> helper = new LinkedList<>();

    public void push(int value) {
        helper.add(value);

        while (!primary.isEmpty()) {
            helper.add(primary.remove());
        }

        Queue<Integer> temp = primary;
        primary = helper;
        helper = temp;
    }

    public int pop() {
        if (primary.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return primary.remove();
    }

    public int top() {
        if (primary.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return primary.peek();
    }

    public boolean isEmpty() {
        return primary.isEmpty();
    }
}

public class StackWithQueuesDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        System.out.println("Enter number of operations:");
        int ops = sc.nextInt();

        while (ops-- > 0) {
            System.out.println("Choose operation: 1-Push  2-Pop  3-Top");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    stack.push(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Popped: " + stack.pop());
                    break;

                case 3:
                    System.out.println("Top: " + stack.top());
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
