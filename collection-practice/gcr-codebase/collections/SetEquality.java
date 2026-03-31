import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        System.out.print("Please enter size of set 1: ");
        int s1 = sc.nextInt();
        System.out.println("Enter elements of set 1:");
        for (int i = 0; i < s1; i++) {
            set1.add(sc.nextInt());
        }

        Set<Integer> set2 = new HashSet<>();
        System.out.print("Please enter size of set 2: ");
        int s2 = sc.nextInt();
        System.out.println("Enter elements of set 2:");
        for (int i = 0; i < s2; i++) {
            set2.add(sc.nextInt());
        }

        if (set1.equals(set2)) {
            System.out.println("Output: true");
        } else {
            System.out.println("Output: false");
        }

        sc.close();
    }
}
