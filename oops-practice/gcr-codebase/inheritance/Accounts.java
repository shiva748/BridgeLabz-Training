class BankAccount {
	int accountNumber;
	double balance;

	public void displayAccountType() {
		System.out.println("Bank Account");
	}
}

class SavingsAccount extends BankAccount {
	double interestRate;

	@Override
	public void displayAccountType() {
		System.out.println("Savings Account");
	}
}

class CheckingAccount extends BankAccount {
	double withdrawalLimit;

	@Override
	public void displayAccountType() {
		System.out.println("Checking Account");
	}
}

class FixedDepositAccount extends BankAccount {
	int depositPeriod;

	@Override
	public void displayAccountType() {
		System.out.println("Fixed Deposit Account");
	}
}

public class Accounts {
	public static void main(String[] args) {
		BankAccount acc1 = new SavingsAccount();
		BankAccount acc2 = new CheckingAccount();
		BankAccount acc3 = new FixedDepositAccount();

		acc1.displayAccountType();
		acc2.displayAccountType();
		acc3.displayAccountType();
	}
}
