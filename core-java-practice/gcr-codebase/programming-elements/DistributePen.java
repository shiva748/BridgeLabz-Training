import java.util.Scanner;

public class DistributePen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter total number of pen's:- ");
        int pen = sc.nextInt();
        System.out.print("Please enter total student's:- ");
        int stu = sc.nextInt();
        System.out.printf("The Pen Per Student is %d and the remaning pen not distributed is %d%n", pen/stu, pen%stu);
        sc.close();
    }
}
