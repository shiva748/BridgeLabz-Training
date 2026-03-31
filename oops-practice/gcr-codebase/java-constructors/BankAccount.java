public class BankAccount {
	public String accountNumber;
	protected String accountHolder;
	private double balance;

	public BankAccount(String accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

class SavingsAccount extends BankAccount {

	private double interestRate;

	public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
		super(accountNumber, accountHolder, balance);
		this.interestRate = interestRate;
	}

	public void displayAccount() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Holder: " + accountHolder);
		System.out.println("Balance: " + getBalance());
		System.out.println("Interest Rate: " + interestRate + "%");
	}
}
