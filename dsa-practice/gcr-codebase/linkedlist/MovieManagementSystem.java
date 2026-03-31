public class MovieManagementSystem {

	// starting of doubly linked list
	private Movie head;
	// end of doubly linked list
	private Movie tail;

	// add a movie at front of the list
	public void addAtFront(Movie movie) {
		if (head == null) {
			head = movie;
			tail = movie;
			return;
		}
		movie.setNext(head);
		head.setPrev(movie);
		head = movie;
	}

	// add a movie at end of the list
	public void addAtLast(Movie movie) {
		if (tail == null) {
			addAtFront(movie);
			return;
		}
		tail.setNext(movie);
		movie.setPrev(tail);
		tail = movie;
	}

	// add a movie at a specific position (1-based index)
	public void addAtPosition(Movie movie, int position) {
		if (position <= 1 || head == null) {
			addAtFront(movie);
			return;
		}

		Movie temp = head;
		int count = 1;

		while (temp.getNext() != null && count < position - 1) {
			temp = temp.getNext();
			count++;
		}

		movie.setNext(temp.getNext());
		movie.setPrev(temp);

		if (temp.getNext() != null) {
			temp.getNext().setPrev(movie);
		} else {
			tail = movie;
		}

		temp.setNext(movie);
	}

	// remove a movie by title
	public void removeMovie(String title) {
		if (head == null) {
			return;
		}

		Movie temp = head;

		while (temp != null) {
			if (temp.getTitle().equals(title)) {

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

	// search movies by director
	public void searchByDirector(String director) {
		Movie temp = head;
		while (temp != null) {
			if (temp.getDirector().equals(director)) {
				printMovie(temp);
			}
			temp = temp.getNext();
		}
	}

	// search movies by rating
	public void searchByRating(double rating) {
		Movie temp = head;
		while (temp != null) {
			if (temp.getRating() == rating) {
				printMovie(temp);
			}
			temp = temp.getNext();
		}
	}

	// update movie rating by title
	public void updateRating(String title, double newRating) {
		Movie temp = head;
		while (temp != null) {
			if (temp.getTitle().equals(title)) {
				temp.setRating(newRating);
				return;
			}
			temp = temp.getNext();
		}
	}

	// display movies in forward order
	public void displayForward() {
		Movie temp = head;
		while (temp != null) {
			printMovie(temp);
			temp = temp.getNext();
		}
	}

	// display movies in reverse order
	public void displayReverse() {
		Movie temp = tail;
		while (temp != null) {
			printMovie(temp);
			temp = temp.getPrev();
		}
	}

	private void printMovie(Movie movie) {
		System.out.println("Title: " + movie.getTitle() + ", Director: " + movie.getDirector() + ", Year: "
				+ movie.getYear() + ", Rating: " + movie.getRating());
	}

	// main method (same usage style as StudentRecordManagement)
	public static void main(String[] args) {

		MovieManagementSystem movies = new MovieManagementSystem();

		movies.addAtFront(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
		movies.addAtFront(new Movie("Interstellar", "Christopher Nolan", 2014, 8.6));
		movies.addAtLast(new Movie("Avatar", "James Cameron", 2009, 7.8));
		movies.addAtLast(new Movie("Titanic", "James Cameron", 1997, 7.9));
		movies.addAtPosition(new Movie("Dunkirk", "Christopher Nolan", 2017, 7.4), 3);

		System.out.println("Movies in forward order:");
		movies.displayForward();

		System.out.println("\nUpdating rating of Avatar:");
		movies.updateRating("Avatar", 8.0);
		movies.displayForward();

		System.out.println("\nSearch movies by director Christopher Nolan:");
		movies.searchByDirector("Christopher Nolan");

		System.out.println("\nMovies in reverse order:");
		movies.displayReverse();

		System.out.println("\nRemoving Titanic:");
		movies.removeMovie("Titanic");
		movies.displayForward();
	}
}

class Movie {
	private String title;
	private String director;
	private int year;
	private double rating;
	private Movie next;
	private Movie prev;

	public Movie(String title, String director, int year, double rating) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
	}

	public void setNext(Movie next) {
		this.next = next;
	}

	public Movie getNext() {
		return this.next;
	}

	public void setPrev(Movie prev) {
		this.prev = prev;
	}

	public Movie getPrev() {
		return this.prev;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDirector() {
		return this.director;
	}

	public int getYear() {
		return this.year;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
