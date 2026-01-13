import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtraction {
	public List<String> extract(String text) {
		Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
		Matcher matcher = pattern.matcher(text);
		List<String> res = new ArrayList<String>();
		while (matcher.find()) {
			res.add(matcher.group());
		}
		return res;
	}

	public static void main(String[] args) {
		DateExtraction extractor = new DateExtraction();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your text: ");
		String text = scanner.nextLine();
		System.out.print(extractor.extract(text).toString());
		scanner.close();
	}
}
