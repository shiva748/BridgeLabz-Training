import java.util.Scanner;

public class TextFormatter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String sentence = input.nextLine();

        String result = formatSentence(sentence);
        System.out.println("After formatting: " + result);

        input.close();
    }

    private static String formatSentence(String text) {

        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder output = new StringBuilder();
        boolean capitalizeNext = true;

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);

            if (Character.isLetter(current)) {
                if (capitalizeNext) {
                    output.append(Character.toUpperCase(current));
                    capitalizeNext = false;
                } else {
                    output.append(current);
                }
            } else if (current == ',' ) {
                output.append(',');
                if (index + 1 < text.length() && text.charAt(index + 1) != ' ') {
                    output.append(' ');
                }
            } else if (current == '.' || current == '!' || current == '?') {
                output.append(current);
                output.append(' ');
                capitalizeNext = true;
            } else if (current == ' ') {
                if (output.length() > 0 && output.charAt(output.length() - 1) != ' ') {
                    output.append(' ');
                }
            } else {
                output.append(current);
            }
        }

        return output.toString().trim();
    }
}
