
import java.util.Scanner;

public class doubleoperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter three numbers:- ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.printf("The results of Int Operations are %.2f, %.2f, %.2f, and %.2f", a+(b*c),(a*b)+c,c+(a/b),(a%b)+c);
        sc.close();
    }
}
