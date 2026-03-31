import java.util.Scanner;

public class SubStringComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter a string: ");
        String text = scanner.nextLine();
        
        System.out.print("Please enter start and end index: ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        if (start < 0 || end < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start and end index");
            return;
        }

        String subString1 = text.substring(start, end);

        StringBuilder subString2 = new StringBuilder();
        for (int i = start; i < end; i++) {
            subString2.append(text.charAt(i));
        }

        boolean isEqual = subString1.equals(subString2.toString());

        System.out.printf(
            "%s %s through substring method is equal to %s through charAt",
            isEqual ? "yes" : "no",
            subString1,
            subString2
        );

        scanner.close();
    }
}
