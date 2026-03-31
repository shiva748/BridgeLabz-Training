import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {
	public boolean match(String userName) {
		String regex = "\\[a-zA-Z]\\w{4,14}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}

	public static void main(String[] args) {
		UsernameValidator validator = new UsernameValidator();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your username: ");
		String userName = scanner.next();
		System.out.printf("%s %s username.", userName, validator.match(userName) ? "is a valid" : "is not a valid");
		scanner.close();
	}
}
