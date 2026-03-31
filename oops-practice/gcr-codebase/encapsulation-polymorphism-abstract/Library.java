import java.util.ArrayList;
import java.util.List;

interface Reservable {
	void reserveItem();

	boolean checkAvailability();
}

abstract class LibraryItem {
	private int itemId;
	private String title;
	private String author;

	LibraryItem(int itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
	}

	abstract int getLoanDuration();

	void getItemDetails() {
		System.out.println(title + " by " + author);
	}
}

class Book extends LibraryItem {
	Book(int id, String title, String author) {
		super(id, title, author);
	}

	int getLoanDuration() {
		return 14;
	}
}

class Magazine extends LibraryItem {
	Magazine(int id, String title, String author) {
		super(id, title, author);
	}

	int getLoanDuration() {
		return 7;
	}
}

class DVD extends LibraryItem implements Reservable {
	DVD(int id, String title, String author) {
		super(id, title, author);
	}

	int getLoanDuration() {
		return 3;
	}

	public void reserveItem() {
		System.out.println("DVD Reserved");
	}

	public boolean checkAvailability() {
		return true;
	}
}

public class Library {
	public static void main(String[] args) {
		List<LibraryItem> items = new ArrayList<>();

		items.add(new Book(1, "Java Basics", "Author A"));
		items.add(new Magazine(2, "Tech Today", "Author B"));
		items.add(new DVD(3, "Learning Java", "Author C"));

		for (LibraryItem item : items) {
			item.getItemDetails();
			System.out.println("Loan Days: " + item.getLoanDuration());
		}
	}
}
