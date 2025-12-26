import java.util.ArrayList;
import java.util.List;

class Book {
	private String title;
	private String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	String getTitle() {
		return title;
	}

	String getAuthor() {
		return author;
	}
}

class Library {
	private String libraryName;
	private List<Book> books;

	Library(String libraryName) {
		this.libraryName = libraryName;
		this.books = new ArrayList<>();
	}

	void addBook(Book book) {
		books.add(book);
	}

	List<Book> getBooks() {
		return books;
	}

	String getLibraryName() {
		return libraryName;
	}
}

public class LibrarySystem {
	public static void main(String[] args) {
		Book b1 = new Book("1984", "George Orwell");
		Book b2 = new Book("The Alchemist", "Paulo Coelho");
		Book b3 = new Book("Clean Code", "Robert Martin");

		Library cityLibrary = new Library("City Library");
		Library collegeLibrary = new Library("College Library");

		cityLibrary.addBook(b1);
		cityLibrary.addBook(b2);

		collegeLibrary.addBook(b2);
		collegeLibrary.addBook(b3);
	}
}
