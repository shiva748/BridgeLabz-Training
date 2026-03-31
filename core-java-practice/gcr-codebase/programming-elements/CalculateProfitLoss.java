import  java.util.Scanner;

public class CalculateProfitLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter C.P:- ");
        int cp = sc.nextInt();
        System.out.print("Please enter S.P:- ");
        int sp = sc.nextInt();
        System.out.printf("The Cost Price is INR %d and Selling Price is INR %d%nThe Profit is INR %d and the Profit Percentage is %.2f",cp, sp, sp-cp, (double)(sp-cp)/cp*100);
        sc.close();
    }
}
