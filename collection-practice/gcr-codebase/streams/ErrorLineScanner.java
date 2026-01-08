import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ErrorLineScanner {

    private ErrorLineScanner() {
        
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java ErrorLineScanner <file-path>");
            return;
        }

        scanForErrors(Path.of(args[0]));
    }

    private static void scanForErrors(Path filePath) {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (containsError(line)) {
                    System.out.println(line);
                }
            }

        } catch (IOException ioException) {
            System.err.println("Unable to read file: " + filePath);
        }
    }

    private static boolean containsError(String text) {
        return text.toLowerCase().contains("error");
    }
}
