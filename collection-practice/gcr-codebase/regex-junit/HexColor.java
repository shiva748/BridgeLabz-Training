import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColor {
	public boolean validate(String color) {
		Pattern pattern = Pattern.compile("#[0-9A-Fa-f]{6}");
		Matcher matcher = pattern.matcher(color);
		return matcher.matches();
	}

	public static void main(String[] args) {
		HexColor hexColor = new HexColor();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter hex color code: ");
		String color = scanner.next();
		System.out.printf("%s is %s valid hex color code.", color, hexColor.validate(color) ? "a" : "not a");
		scanner.close();
	}
}
