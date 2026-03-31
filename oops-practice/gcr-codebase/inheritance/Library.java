class Book {
	String title;
	int publicationYear;

	public void displayInfo() {
		System.out.println("Book Title: " + title);
		System.out.println("Publication Year: " + publicationYear);
	}
}

class Author extends Book {
	String name;
	String bio;

	@Override
	public void displayInfo() {
		System.out.println("Book Title: " + title);
		System.out.println("Publication Year: " + publicationYear);
		System.out.println("Author Name: " + name);
		System.out.println("Author Bio: " + bio);
	}
}

public class Library {
	public static void main(String[] args) {
		Book book = new Author();
		book.title = "Java Fundamentals";
		book.publicationYear = 2023;

		Author author = (Author) book;
		author.name = "Ravi Kumar";
		author.bio = "Software Developer and Java Trainer";

		book.displayInfo();
	}
}
