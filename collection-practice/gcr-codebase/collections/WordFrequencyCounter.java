import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String text = "Hello world, hello Java!";
        text = text.toLowerCase();

        Map<String, Integer> wordCount = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                currentWord.append(ch);
            } else {
                if (currentWord.length() > 0) {
                    String word = currentWord.toString();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    currentWord.setLength(0);
                }
            }
        }
        
        if (currentWord.length() > 0) {
            String word = currentWord.toString();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println(wordCount);
    }
}
