import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InfoFileReader {
    public static void main(String[] args) {
        Path path = Path.of("info.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }
}
