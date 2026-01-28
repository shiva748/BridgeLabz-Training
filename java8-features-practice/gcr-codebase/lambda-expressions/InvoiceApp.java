import java.util.List;
import java.util.stream.Collectors;

public class InvoiceApp {

	public static void main(String[] args) {

		List<String> transactionIds = List.of("TXN-1001", "TXN-1002", "TXN-1003", "TXN-1004");

		List<Invoice> invoices = transactionIds.stream().map(Invoice::new).collect(Collectors.toList());

		invoices.forEach(System.out::println);
	}
}

class Invoice {

	private final String transactionId;

	public Invoice(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		return "Invoice{ transactionId='" + transactionId + "' }";
	}
}
