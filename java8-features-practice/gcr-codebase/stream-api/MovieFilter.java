import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Movie {
	String name;
	double rating;
	int releaseYear;

	Movie(String name, double rating, int releaseYear) {
		this.name = name;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}

	public double getRating() {
		return rating;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public String toString() {
		return name + " (" + releaseYear + ") - " + rating;
	}
}

public class MovieFilter {
	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(new Movie("Movie A", 8.9, 2023), new Movie("Movie B", 9.1, 2022),
				new Movie("Movie C", 8.7, 2024), new Movie("Movie D", 9.1, 2021), new Movie("Movie E", 8.5, 2023),
				new Movie("Movie F", 9.3, 2024), new Movie("Movie G", 8.8, 2022));

		List<Movie> top5Movies = movies.stream().filter(m -> m.getRating() >= 8.5).sorted(
				Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getReleaseYear).reversed())
				.collect(Collectors.toList());

		top5Movies.forEach(System.out::println);
	}
}
