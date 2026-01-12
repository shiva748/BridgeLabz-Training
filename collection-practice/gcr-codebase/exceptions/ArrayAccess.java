import java.util.Scanner;

public class ArrayAccess {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30, 40};
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index!");
        } catch (NullPointerException e) {
            System.err.println("Array is not initialized!");
        }
    }
}
