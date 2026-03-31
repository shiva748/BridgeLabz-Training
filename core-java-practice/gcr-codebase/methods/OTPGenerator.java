import java.util.Arrays;

public class OTPGenerator {
	public static int generateOTP() {
		return (int) (Math.random() * 900000) + 100000;
	}
	public static boolean uniqueOTPs(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] == arr[j])
					return false;
		return true;
	}
	public static void main(String[] args) {
		int[] otp = new int[10];
		for (int i = 0; i < otp.length; i++)
			otp[i] = generateOTP();
		System.out.println("Generated OTPs: " + Arrays.toString(otp));
		System.out.printf("Unique = %b%n", uniqueOTPs(otp));
	}
}