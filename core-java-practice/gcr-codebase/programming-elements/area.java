import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter radius of circle:- ");
        int r = sc.nextInt();
        System.err.printf("Area of circle is: %.2f", Math.PI*(Math.pow(r, 2)));
        sc.close();
    }    
}
