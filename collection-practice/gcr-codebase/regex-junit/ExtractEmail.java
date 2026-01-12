import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmail {

	public List<String> extract(String text) {
		Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b");
		Matcher matcher = pattern.matcher(text);

		List<String> match = new ArrayList<>();

		while (matcher.find()) {
			match.add(matcher.group());
		}

		return match;
	}

	public static void main(String[] args) {
		ExtractEmail extractor = new ExtractEmail();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter text to be search for email: ");
		String text = scanner.nextLine();

		System.out.println(extractor.extract(text));

		scanner.close();
	}
}
