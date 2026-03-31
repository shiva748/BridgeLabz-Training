import java.io.*;

public class ImageByteConverter {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("input.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while ((b = fis.read()) != -1) {
                baos.write(b);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("output.jpg");

            while ((b = bais.read()) != -1) {
                fos.write(b);
            }

            fis.close();
            fos.close();

            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            System.out.println("Error processing image.");
        }
    }
}
