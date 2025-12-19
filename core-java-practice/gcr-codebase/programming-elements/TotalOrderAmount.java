
import java.util.Scanner;

public class TotalOrderAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter price of a unit:- ");
        float price = sc.nextFloat();
        System.out.print("Please enter total unit's to be bought:- ");
        int unit = sc.nextInt();
        System.out.printf("The total cost of buying %d units @ %.2f/unit is %.2f", unit, price, unit*price);
        sc.close();
    }   
}
