public class SecuritySystem {

	public static void main(String[] args) {

		checkPassword("pass123");
		checkPassword("Password@123");
		checkPassword("admin");
		checkPassword("Secure@2026");
	}

	public static void checkPassword(String password) {

		boolean strong = SecurityUtils.checkPasswordStrength(password);

		if (strong) {
			System.out.println("Password is strong.");
			return;
		}

		System.out.println("Password is weak.");
	}
}

interface SecurityUtils {

	public static boolean checkPasswordStrength(String password) {

		if (password == null) {
			return false;
		}

		if (password.length() < 8) {
			return false;
		}

		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;
		boolean hasSpecial = false;

		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (Character.isUpperCase(ch)) {
				hasUpper = true;
			} else if (Character.isLowerCase(ch)) {
				hasLower = true;
			} else if (Character.isDigit(ch)) {
				hasDigit = true;
			} else {
				hasSpecial = true;
			}
		}

		if (hasUpper && hasLower && hasDigit && hasSpecial) {
			return true;
		}

		return false;
	}
}
