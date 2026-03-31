import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
	private String title;
	private String genre;
	private int pages;

	Book(String title, String genre, int pages) {
		this.title = title;
		this.genre = genre;
		this.pages = pages;
	}

	public String getGenre() {
		return genre;
	}

	public int getPages() {
		return pages;
	}
}

public class BookStatistics {
	public static void main(String[] args) {

		List<Book> books = Arrays.asList(new Book("Book A", "Fiction", 320), new Book("Book B", "Fiction", 450),
				new Book("Book C", "Science", 500), new Book("Book D", "Science", 380),
				new Book("Book E", "History", 600), new Book("Book F", "History", 420),
				new Book("Book G", "Fiction", 280));

		Map<String, IntSummaryStatistics> statsByGenre = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));

		statsByGenre.forEach((genre, stats) -> {
			System.out.println("Genre: " + genre);
			System.out.println("Total Pages: " + stats.getSum());
			System.out.println("Average Pages: " + stats.getAverage());
			System.out.println("Max Pages: " + stats.getMax());
			System.out.println();
		});
	}
}
