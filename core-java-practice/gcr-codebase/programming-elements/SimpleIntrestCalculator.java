
import java.util.Scanner;

public class SimpleIntrestCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter Principal amount:- ");
        int amt = sc.nextInt();
        System.out.print("Please enter Rate of interest:- ");
        float rate = sc.nextFloat();
        System.out.print("Please enter Time period in years:- ");
        int time = sc.nextInt();
        float si = (amt * rate * time) / 100;
        System.out.printf("Simple Interest is:- %.2f", si);
        sc.close();
    }
}
