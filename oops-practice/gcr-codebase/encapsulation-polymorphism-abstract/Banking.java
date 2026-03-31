import java.util.ArrayList;
import java.util.List;

interface Loanable {
	void applyForLoan();

	double calculateLoanEligibility();
}

abstract class BankAccount {
	private int accountNumber;
	private String holderName;
	private double balance;

	BankAccount(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	double getBalance() {
		return balance;
	}

	void deposit(double amount) {
		balance += amount;
	}

	void withdraw(double amount) {
		balance -= amount;
	}

	abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
	SavingsAccount(int acc, String name, double bal) {
		super(acc, name, bal);
	}

	double calculateInterest() {
		return getBalance() * 0.04;
	}

	public void applyForLoan() {
		System.out.println("Loan Applied");
	}

	public double calculateLoanEligibility() {
		return getBalance() * 5;
	}
}

class CurrentAccount extends BankAccount {
	CurrentAccount(int acc, String name, double bal) {
		super(acc, name, bal);
	}

	double calculateInterest() {
		return getBalance() * 0.01;
	}
}

public class Banking {
	public static void main(String[] args) {
		List<BankAccount> accounts = new ArrayList<>();

		accounts.add(new SavingsAccount(1, "Anil", 50000));
		accounts.add(new CurrentAccount(2, "Sunil", 80000));

		for (BankAccount acc : accounts) {
			System.out.println("Interest: " + acc.calculateInterest());
		}
	}
}
