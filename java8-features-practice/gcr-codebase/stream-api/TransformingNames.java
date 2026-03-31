import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformingNames {
	public static void main(String[] args) {
		List<String> customerName = Arrays.asList("Shiva", "Anu", "Richa", "Diya", "Tia", "Dileep", "Mamta", "Hardik");
		System.out.print(customerName.stream().map(String::toUpperCase).sorted().collect(Collectors.toList()));
	}
}
