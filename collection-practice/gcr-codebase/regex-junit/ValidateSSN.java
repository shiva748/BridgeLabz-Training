import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
	public String extract(String text) {
		Pattern pattern = Pattern.compile("\\b\\d+-?\\d+-?\\d+-?\\b");
		Matcher matcher = pattern.matcher(text);
		return matcher.find() ? matcher.group() : "";
	}

	public String validate(String text) {
		Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		String ssn = extract(text);
		return pattern.matcher(ssn).matches() ? ssn + " is valid ssn." : ssn + "is not valid ssn.";
	}

	public static void main(String[] args) {
		ValidateSSN validate = new ValidateSSN();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your SSN: ");
		String ssn = scanner.nextLine();
		System.out.println(validate.validate(ssn));
		scanner.close();
	}
}
