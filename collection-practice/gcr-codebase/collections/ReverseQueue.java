import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {

    private static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }

        int front = q.remove();
        reverse(q);
        q.add(front);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            queue.add(sc.nextInt());
        }

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);

        sc.close();
    }
}
