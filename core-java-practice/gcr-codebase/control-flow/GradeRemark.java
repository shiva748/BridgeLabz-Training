import java.util.Scanner;

public class GradeRemark {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter marks in PCM:- ");
		int physics = scanner.nextInt();
		int chemistry = scanner.nextInt();
		int math = scanner.nextInt();
		double average = (double) (physics + math + chemistry) / 3;
		if (average >= 80) {
			System.out.println("above agency-normalized standards");
		} else if (average >= 70) {
			System.out.println("at agency-normalized standards");
		} else if (average >= 60) {
			System.out.println("below, but approaching agency-normalized standards");
		} else if (average >= 50) {
			System.out.println("well below agency-normalized standards");
		} else if (average >= 40) {
			System.out.println("to below agency-normalized standards");
		} else {
			System.out.println("Remedial standards");
		}
		scanner.close();
	}

}
