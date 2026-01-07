import java.util.Scanner;

public class ParagraphAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a paragraph: ");
        String text = input.nextLine().trim();

        int wordCount = countWords(text);
        String longest = getLongestWord(text);

        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longest);

        System.out.print("Enter word to replace: ");
        String find = input.next();

        System.out.print("Enter replacement word: ");
        String replaceWith = input.next();

        String updatedText = replaceWord(text, find, replaceWith);

        System.out.println("Updated Paragraph:");
        System.out.println(updatedText);

        input.close();
    }

    private static int countWords(String text) {
        int count = 0;
        boolean insideWord = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !insideWord) {
                count++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }
        return count;
    }

    private static String getLongestWord(String text) {
        String longest = "";
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                current.append(ch);
            } else {
                if (current.length() > longest.length()) {
                    longest = current.toString();
                }
                current.setLength(0);
            }
        }

        if (current.length() > longest.length()) {
            longest = current.toString();
        }

        return longest;
    }

    private static String replaceWord(String text, String target, String replacement) {

        StringBuilder output = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i <= text.length(); i++) {

            if (i < text.length() && text.charAt(i) != ' ') {
                current.append(text.charAt(i));
            } else {
                if (current.toString().equals(target)) {
                    output.append(replacement);
                } else {
                    output.append(current);
                }

                if (i < text.length()) {
                    output.append(' ');
                }
                current.setLength(0);
            }
        }

        return output.toString();
    }
}
