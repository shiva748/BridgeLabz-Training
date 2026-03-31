
import java.util.Scanner;

public class ConvertFeet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter you distance in feet's:- ");
        float feet = sc.nextFloat();
        System.out.printf("The distance of %.2f feet is equivalent to %.2f yard and %.2f mile", feet, feet/3, feet/(3*1760));
        sc.close();
    }
}
