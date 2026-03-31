import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SetToSortedList {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        HashSet<Integer> numbers = new HashSet<>();

        System.out.print("Enter total elements: ");
        int count = reader.nextInt();

        System.out.println("Enter values:");
        for (int i = 0; i < count; i++) {
            numbers.add(reader.nextInt());
        }

        List<Integer> sortedValues = new ArrayList<>(numbers);
        Collections.sort(sortedValues);

        System.out.println("Sorted List: " + sortedValues);

        reader.close();
    }
}
