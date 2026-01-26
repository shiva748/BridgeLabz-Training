import java.util.Arrays;
import java.util.List;

public class EmployeeNameUppercase {

    public static void main(String[] args) {

        List<String> employees = Arrays.asList(
                "Amit",
                "Neha",
                "Rohit",
                "Kavya",
                "Arjun");

        employees.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}