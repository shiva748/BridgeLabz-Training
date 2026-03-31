import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i < num; i++){
            lst.add(i);
        }
        List<Integer> reverse = new ArrayList<>();
        for(int i = num-1; i >= 0; i--){
            reverse.add(lst.get(i));
        }
        System.out.println(reverse.toString());
        sc.close();
    }
}
