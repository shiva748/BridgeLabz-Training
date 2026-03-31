import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPlateValidator {
	public boolean validate(String numberPlate) {
		Pattern pattern = Pattern.compile("^[A-Z]{2}\\d{4}$");
		Matcher matcher = pattern.matcher(numberPlate);
		return matcher.matches();
	}

	public static void main(String[] args) {
		NumberPlateValidator validator = new NumberPlateValidator();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter Number: ");
		String numberPlate = scanner.next();
		System.out.printf("%s is %s valid number plate", numberPlate, validator.validate(numberPlate) ? "a" : "not a");
		scanner.close();
	}
}
