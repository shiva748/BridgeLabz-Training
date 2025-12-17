
import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Please enter base:- ");
        int base = sc.nextInt();
        System.err.print("Please enter exponent:- ");
        int exponent = sc.nextInt();
        System.out.println("Result: " + Math.pow(base, exponent));
        sc.close();
    }
}
