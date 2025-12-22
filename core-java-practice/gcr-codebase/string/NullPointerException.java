
public class NullPointerException {

	public static void main(String[] args) {
		try {
			String text=null;
			System.out.println(text.length());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
