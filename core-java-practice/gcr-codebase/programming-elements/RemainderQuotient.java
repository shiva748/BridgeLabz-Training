
import java.util.Scanner;

public class RemainderQuotient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter two numbers:- ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.printf("For divison of %d/%d the quotient is %d and remainder is %d", a, b, a/b, a%b);
        sc.close();
    }
}
