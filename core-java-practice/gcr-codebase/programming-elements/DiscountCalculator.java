
import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the fee amount INR:- ");
            int amt = sc.nextInt();
            System.out.print("Please enter discount %:- ");
            double dis = sc.nextDouble();
            System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f%n", (double)(amt*dis)/100, (double)(amt*(100-dis))/100);
            sc.close();
    }
}
