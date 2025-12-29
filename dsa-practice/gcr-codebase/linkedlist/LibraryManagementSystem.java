public class LibraryManagementSystem {

	// starting of doubly linked list
	private Book head;
	// end of doubly linked list
	private Book tail;

	// add a book at front of the list
	public void addAtFront(Book book) {
		if (head == null) {
			head = book;
			tail = book;
			return;
		}
		book.setNext(head);
		head.setPrev(book);
		head = book;
	}

	// add a book at end of the list
	public void addAtLast(Book book) {
		if (tail == null) {
			addAtFront(book);
			return;
		}
		tail.setNext(book);
		book.setPrev(tail);
		tail = book;
	}

	// add a book at a specific position (1-based index)
	public void addAtPosition(Book book, int position) {
		if (position <= 1 || head == null) {
			addAtFront(book);
			return;
		}

		Book temp = head;
		int count = 1;

		while (temp.getNext() != null && count < position - 1) {
			temp = temp.getNext();
			count++;
		}

		book.setNext(temp.getNext());
		book.setPrev(temp);

		if (temp.getNext() != null) {
			temp.getNext().setPrev(book);
		} else {
			tail = book;
		}

		temp.setNext(book);
	}

	// remove a book by book id
	public void removeBook(int bookId) {
		if (head == null) {
			return;
		}

		Book temp = head;

		while (temp != null) {
			if (temp.getBookId() == bookId) {

				if (temp == head) {
					head = head.getNext();
					if (head != null) {
						head.setPrev(null);
					} else {
						tail = null;
					}
				} else if (temp == tail) {
					tail = tail.getPrev();
					tail.setNext(null);
				} else {
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());
				}
				return;
			}
			temp = temp.getNext();
		}
	}

	// search book by title
	public void searchByTitle(String title) {
		Book temp = head;
		while (temp != null) {
			if (temp.getTitle().equals(title)) {
				printBook(temp);
			}
			temp = temp.getNext();
		}
	}

	// search book by author
	public void searchByAuthor(String author) {
		Book temp = head;
		while (temp != null) {
			if (temp.getAuthor().equals(author)) {
				printBook(temp);
			}
			temp = temp.getNext();
		}
	}

	// update availability status by book id
	public void updateAvailability(int bookId, boolean status) {
		Book temp = head;
		while (temp != null) {
			if (temp.getBookId() == bookId) {
				temp.setAvailable(status);
				return;
			}
			temp = temp.getNext();
		}
	}

	// display books in forward order
	public void displayForward() {
		Book temp = head;
		while (temp != null) {
			printBook(temp);
			temp = temp.getNext();
		}
	}

	// display books in reverse order
	public void displayReverse() {
		Book temp = tail;
		while (temp != null) {
			printBook(temp);
			temp = temp.getPrev();
		}
	}

	// count total number of books
	public int countBooks() {
		int count = 0;
		Book temp = head;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	private void printBook(Book book) {
		System.out.println("Book ID: " + book.getBookId() + ", Title: " + book.getTitle() + ", Author: "
				+ book.getAuthor() + ", Genre: " + book.getGenre() + ", Available: " + book.isAvailable());
	}

	// main method (same style as previous programs)
	public static void main(String[] args) {

		LibraryManagementSystem library = new LibraryManagementSystem();

		library.addAtFront(new Book(1, "Clean Code", "Robert Martin", "Programming", true));
		library.addAtLast(new Book(2, "The Alchemist", "Paulo Coelho", "Fiction", true));
		library.addAtLast(new Book(3, "1984", "George Orwell", "Dystopian", false));
		library.addAtPosition(new Book(4, "Atomic Habits", "James Clear", "Self Help", true), 2);

		System.out.println("All Books (Forward):");
		library.displayForward();

		System.out.println("\nAll Books (Reverse):");
		library.displayReverse();

		System.out.println("\nSearch book by author George Orwell:");
		library.searchByAuthor("George Orwell");

		System.out.println("\nUpdating availability of book ID 3:");
		library.updateAvailability(3, true);
		library.displayForward();

		System.out.println("\nRemoving book with ID 2:");
		library.removeBook(2);
		library.displayForward();

		System.out.println("\nTotal number of books: " + library.countBooks());
	}
}

class Book {
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private boolean available;
	private Book next;
	private Book prev;

	public Book(int bookId, String title, String author, String genre, boolean available) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.available = available;
	}

	public void setNext(Book next) {
		this.next = next;
	}

	public Book getNext() {
		return this.next;
	}

	public void setPrev(Book prev) {
		this.prev = prev;
	}

	public Book getPrev() {
		return this.prev;
	}

	public int getBookId() {
		return this.bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getGenre() {
		return this.genre;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
