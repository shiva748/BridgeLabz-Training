
import java.util.Scanner;

public class handshake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of student's:- ");
        int n = sc.nextInt();
        System.out.printf("Maximum number of handshake is %d", n*(n-1)/2);
        sc.close();
    }
}
