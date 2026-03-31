import java.util.HashMap;
import java.util.Map;

class Bank {
	private String bankTitle;
	private Map<Customer, Double> accountData;

	Bank(String bankTitle) {
		this.bankTitle = bankTitle;
		this.accountData = new HashMap<>();
	}

	void openAccount(Customer customer, double initialAmount) {
		accountData.put(customer, initialAmount);
		customer.linkBank(this);
	}

	double fetchBalance(Customer customer) {
		return accountData.getOrDefault(customer, 0.0);
	}

	String getBankTitle() {
		return bankTitle;
	}
}

class Customer {
	private String customerName;
	private Bank associatedBank;

	Customer(String customerName) {
		this.customerName = customerName;
	}

	void linkBank(Bank bank) {
		this.associatedBank = bank;
	}

	void viewBalance() {
		if (associatedBank != null) {
			double balance = associatedBank.fetchBalance(this);
		}
	}

	String getCustomerName() {
		return customerName;
	}
}

public class BankAssociationApp {
	public static void main(String[] args) {
		Bank axis = new Bank("Axis Bank");

		Customer ramesh = new Customer("Ramesh");
		Customer suresh = new Customer("Suresh");

		axis.openAccount(ramesh, 5000);
		axis.openAccount(suresh, 12000);

		ramesh.viewBalance();
		suresh.viewBalance();
	}
}
