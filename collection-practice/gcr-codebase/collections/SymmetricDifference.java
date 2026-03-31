import java.util.HashSet;
import java.util.Scanner;

public class SymmetricDifference {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();

        System.out.print("Enter number of elements in first set: ");
        int n1 = input.nextInt();
        System.out.println("Enter elements:");
        while (n1-- > 0) {
            firstSet.add(input.nextInt());
        }

        System.out.print("Enter number of elements in second set: ");
        int n2 = input.nextInt();
        System.out.println("Enter elements:");
        while (n2-- > 0) {
            secondSet.add(input.nextInt());
        }

        HashSet<Integer> result = new HashSet<>();

        for (int value : firstSet) {
            if (!secondSet.contains(value)) {
                result.add(value);
            }
        }

        for (int value : secondSet) {
            if (!firstSet.contains(value)) {
                result.add(value);
            }
        }

        System.out.println("Symmetric Difference: " + result);

        input.close();
    }
}
