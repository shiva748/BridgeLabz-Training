import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter a string: ");
		String text = scanner.next();
		StringBuilder modified = new StringBuilder();
		HashSet<Character> doExist = new HashSet<Character>();
		for(int i = 0; i < text.length(); i++) {
			if(!doExist.contains(text.charAt(i))) {
				doExist.add(text.charAt(i));
				modified.append(text.charAt(i));
			}
		}
		System.out.printf("%s modified string is %s", text, modified.toString());
		scanner.close();
	}

}
