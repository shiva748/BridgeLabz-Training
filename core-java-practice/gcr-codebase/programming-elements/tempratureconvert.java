
import java.util.Scanner;

public class tempratureconvert {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the temprature in celsius:- ");
        double temp = sc.nextDouble();
        double fah = (temp * 9 / 5) + 32;
        System.out.println(fah);
        sc.close();
    }
}
