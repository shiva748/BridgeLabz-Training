import java.util.Scanner;

public class AgeOfHarry
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter birtyear:- ");
        int birth = sc.nextInt();
        System.out.println("Harry's age in 2024 is:- "+(2024-birth));
        sc.close(); 
    }
}