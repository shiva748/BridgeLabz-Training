
import java.util.Scanner;

public class ConversionKmToMile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter distance in km:- ");
        int km = sc.nextInt();
        System.out.printf("Distance in miles is:- %.2f", km * 0.621371);
        sc.close();
    }
}
