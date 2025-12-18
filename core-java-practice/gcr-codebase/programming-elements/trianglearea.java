
import java.util.Scanner;

public class trianglearea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter base of triangle:- ");
        float base = sc.nextFloat();
        System.out.print("Please enter height of triangle:- ");
        float height = sc.nextFloat();
        System.out.printf("Area of triangle cm^2 is %.2f and in inch^2 is %.2f", 0.5*base*height, (0.5*base*height)/2.54);
        sc.close();
    }
}
