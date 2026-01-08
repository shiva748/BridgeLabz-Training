import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentBinaryStorage {

    private static final String FILE_PATH = "student_data.bin";

    public static void main(String[] args) {
        writeStudentData(101, "Aarav Sharma", 8.72);
        readStudentData();
    }

    private static void writeStudentData(int rollNumber, String studentName, double gpa) {
        try (DataOutputStream dataWriter =
                     new DataOutputStream(new FileOutputStream(FILE_PATH))) {

            dataWriter.writeInt(rollNumber);
            dataWriter.writeUTF(studentName);
            dataWriter.writeDouble(gpa);

            System.out.println("Student data successfully written to file.");

        } catch (IOException exception) {
            System.err.println("Failed to write student data.");
            exception.printStackTrace();
        }
    }

    private static void readStudentData() {
        try (DataInputStream dataReader =
                     new DataInputStream(new FileInputStream(FILE_PATH))) {

            int rollNumber = dataReader.readInt();
            String studentName = dataReader.readUTF();
            double gpa = dataReader.readDouble();

            System.out.println("Retrieved Student Details:");
            System.out.println("Roll Number : " + rollNumber);
            System.out.println("Name        : " + studentName);
            System.out.println("GPA         : " + gpa);

        } catch (IOException exception) {
            System.err.println("Failed to read student data.");
            exception.printStackTrace();
        }
    }
}
