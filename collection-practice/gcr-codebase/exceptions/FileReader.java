
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static void main(String[] args) {
        try {
            Path path = Path.of("data.txt");
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while((line = reader.readLine()) != null){
                System.err.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage()+" Not found.");
        }
    }
}
