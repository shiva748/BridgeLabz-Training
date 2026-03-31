import java.util.function.Function;

public class StringLength {

	public static void main(String[] args) {

		int limit = 20;

		Function<String, Integer> lengthCheck = msg -> msg.length();

		checkMessage("Hello World", limit, lengthCheck);
		checkMessage("This is a very long message for testing", limit, lengthCheck);
		checkMessage("Java", limit, lengthCheck);
		checkMessage("Functional interfaces are powerful", limit, lengthCheck);
	}

	public static void checkMessage(String message, int limit, Function<String, Integer> lengthCheck) {

		int length = lengthCheck.apply(message);

		if (length > limit) {
			System.out.println("Message exceeds character limit.");
			System.out.println("Length: " + length + " | Limit: " + limit);
			return;
		}

		System.out.println("Message is within limit.");
		System.out.println("Length: " + length + " | Limit: " + limit);
	}
}
