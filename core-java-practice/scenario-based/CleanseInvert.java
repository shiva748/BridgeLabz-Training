import java.util.Scanner;

public class CleanseInvert {

    public static String CleanseAndInvert(String input) {
        if (input == null || input.length() < 6) return "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return "";
            }
        }

        String lower = input.toLowerCase();

        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if ((int) c % 2 != 0) {
                filtered.append(c);
            }
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed.append(filtered.charAt(i));
        }

        for (int i = 0; i < reversed.length(); i++) {
            if (i % 2 == 0) {
                reversed.setCharAt(i, (char)(reversed.charAt(i) - 32));
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);

        if (result.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }

        sc.close();
    }
}
