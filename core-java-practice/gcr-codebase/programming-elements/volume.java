
import java.util.Scanner;

public class volume {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the radius:- ");
        int radius = sc.nextInt();
        System.out.print("Please enter the height:- ");
        int height = sc.nextInt();
        System.out.printf("Volume of cylinder is:- %.2f", Math.PI * Math.pow(radius, 2) * height);
        sc.close();
    }
}
