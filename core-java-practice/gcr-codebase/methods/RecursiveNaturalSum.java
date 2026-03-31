import java.util.Scanner;

public class RecursiveNaturalSum {
	
	public static int naturalNumberSum(int num) {
		if(num <= 0) {
			return 0;
		}
		return num + naturalNumberSum(num-1);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a number: ");
		int num = scanner.nextInt();
		System.out.printf("sum through recursive %d is equals sum through formula %d", naturalNumberSum(num), num*(num+1)/2);
		scanner.close();
	}

}
