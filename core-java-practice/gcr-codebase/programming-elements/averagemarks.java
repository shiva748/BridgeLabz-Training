
import java.util.Scanner;
import java.util.function.Supplier;


public class averagemarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supplier<Integer> getmarks = ()-> sc.nextInt();
        System.out.print("Please enter physics marks:- ");
        int phy = getmarks.get();
        System.out.print("Please enter chemistry:- ");
        int che = getmarks.get();
        System.out.print("Please enter math marks:- ");
        int math = getmarks.get();
        System.out.printf("Average marks: %.2f", (double)(phy+che+math)/3);
        sc.close();
    }
}
