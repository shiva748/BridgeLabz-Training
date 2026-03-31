import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i < num; i++){
            lst.add(sc.nextInt());
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < num; i++){
            set.add(lst.get(i));
        }
        lst = set.stream().toList();
        System.out.println(lst.toString());
        sc.close();
    }
}
