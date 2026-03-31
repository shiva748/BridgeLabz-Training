
import java.util.Scanner;

public class OperationOnInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter three numbers:- ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        System.out.printf("The results of Int Operations are %d, %d, %d, and %d", a+(b*c),(a*b)+c,c+(a/b),(a%b)+c);
        sc.close();
    }
}
