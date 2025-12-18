
import java.util.Scanner;

public class side {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter perimeter of square:- ");
        int per = sc.nextInt();
        System.out.println("side of square is "+per/4);
        sc.close();
    }
}
