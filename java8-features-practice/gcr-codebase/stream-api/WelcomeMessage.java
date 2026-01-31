import java.util.Arrays;
import java.util.List;

public class WelcomeMessage {
	public static void main(String[] args) {
		List<String> attendee = Arrays.asList("Shiva", "Anu", "Richa", "Diya", "Tia", "Dileep", "Mamta", "Hardik");
		attendee.stream().forEach((a) -> System.out.printf("%s welcome to you.%n", a));
	}
}