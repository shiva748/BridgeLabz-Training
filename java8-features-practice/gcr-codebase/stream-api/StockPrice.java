import java.util.Arrays;
import java.util.List;

class Stock {
	private String symbol;
	private double price;

	Stock(String symbol, double price) {
		this.symbol = symbol;
		this.price = price;
	}

	public String toString() {
		return symbol + " : " + price;
	}
}

public class StockPrice {
	public static void main(String[] args) {

		List<Stock> liveFeed = Arrays.asList(new Stock("AAPL", 189.45), new Stock("GOOGL", 142.30),
				new Stock("AMZN", 156.10), new Stock("MSFT", 412.75));

		liveFeed.stream().forEach(System.out::println);
	}
}
