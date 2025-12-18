
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter two numbers:- ");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f%n", a, b, a+b, a-b, a*b, a/b);
        sc.close();
    }
}
