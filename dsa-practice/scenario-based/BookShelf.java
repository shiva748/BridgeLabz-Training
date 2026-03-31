
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Book {

    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book)) {
            return false;
        }
        Book b = (Book) o;
        return title.equalsIgnoreCase(b.title)
                && author.equalsIgnoreCase(b.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase());
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class Library {

    private Map<String, LinkedList<Book>> catalog = new HashMap<>();
    private Set<Book> uniqueBooks = new HashSet<>();

    public void addBook(String genre, Book book) {
        if (!uniqueBooks.add(book)) {
            System.out.println("Duplicate book ignored: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        System.out.println("Book added: " + book);
    }

    public void borrowBook(String genre, Book book) {
        LinkedList<Book> list = catalog.get(genre);

        if (list != null && list.remove(book)) {
            uniqueBooks.remove(book);
            System.out.println("Book borrowed: " + book);
        } else {
            System.out.println("Book not available.");
        }
    }

    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }
}

public class BookShelf {

    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("Dune", "Frank Herbert");
        Book b3 = new Book("1984", "George Orwell"); // duplicate

        library.addBook("Fiction", b1);
        library.addBook("Sci-Fi", b2);
        library.addBook("Fiction", b3);

        library.displayCatalog();

        library.borrowBook("Fiction", b1);
        library.displayCatalog();
    }
}
