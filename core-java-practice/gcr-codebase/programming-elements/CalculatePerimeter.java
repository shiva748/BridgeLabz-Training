
import java.util.Scanner;

public class CalculatePerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter length:- ");
        int length = sc.nextInt();
        System.out.print("Please enter breadth:- ");
        int breadth = sc.nextInt();
        System.out.printf("Perimeter of rectangle is:- %d", 2 * (length + breadth));
        sc.close();
    }
}
