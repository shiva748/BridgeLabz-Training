public class LibraryBook {
	public String ISBN;
	protected String title;
	private String author;

	public LibraryBook(String ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

class EBook extends LibraryBook {

	private double fileSize;

	public EBook(String ISBN, String title, String author, double fileSize) {
		super(ISBN, title, author);
		this.fileSize = fileSize;
	}

	public void displayEBook() {
		System.out.println("ISBN: " + ISBN);
		System.out.println("Title: " + title);
		System.out.println("Author: " + getAuthor());
		System.out.println("File Size: " + fileSize + " mb");
	}
}