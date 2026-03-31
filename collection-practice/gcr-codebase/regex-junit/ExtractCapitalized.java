import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCapitalized {

	public List<String> extract(String text) {
		Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
		Matcher matcher = pattern.matcher(text);

		List<String> res = new ArrayList<>();

		while (matcher.find()) {
			res.add(matcher.group());
		}

		return res;
	}

	public static void main(String[] args) {
		ExtractCapitalized extractor = new ExtractCapitalized();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a text: ");
		String text = scanner.nextLine();

		System.out.println(extractor.extract(text));

		scanner.close();
	}
}
