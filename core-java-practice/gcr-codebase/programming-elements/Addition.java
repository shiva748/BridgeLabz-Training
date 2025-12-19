
import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter first Number:- ");
        int a = sc.nextInt();
        System.out.print("Please enter second Number:- ");
        int b = sc.nextInt();
        System.out.println("Sum:- "+(a+b));
        sc.close();
    }
}
