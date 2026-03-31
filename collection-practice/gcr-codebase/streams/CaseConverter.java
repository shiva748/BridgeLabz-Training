import java.io.*;

public class CaseConverter {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase((char) ch));
            }

            reader.close();
            writer.close();

            System.out.println("Text converted to lowercase.");

        } catch (IOException e) {
            System.out.println("File processing error.");
        }
    }
}
