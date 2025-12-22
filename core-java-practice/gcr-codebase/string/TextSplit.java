import java.util.Scanner;

public class TextSplit {

    public static String[] splitWords(String text) {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }
        String[] words = new String[count];
        StringBuilder word = new StringBuilder();
        int index = 0;
        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() > 0) {
                words[index++] = word.toString();
                word.setLength(0);
            }
        }
        if (word.length() > 0) {
            words[index] = word.toString();
        }
        return words;
    }
    public static int getLength(String str) {
        int length = 0;
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (Exception e) {
        }
        return length;
    }
    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        String[] words = splitWords(text);
        String[][] wordLengthArray = createWordLengthArray(words);
        System.out.println("\nWord\t\tLength");
        System.out.println("---------------------");

        for (int i = 0; i < wordLengthArray.length; i++) {
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]);
            System.out.println(word + "\t\t" + length);
        }

        scanner.close();
    }
}
