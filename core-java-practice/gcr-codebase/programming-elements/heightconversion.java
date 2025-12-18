
import java.util.Scanner;

public class heightconversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your height in cm:- ");
        double height = sc.nextDouble();
        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f", height, height/(12*2.54), height/2.54);
        sc.close();
    }
}
