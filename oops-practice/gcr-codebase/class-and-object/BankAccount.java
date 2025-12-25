public class BankAccount {
	private String accountHolder;
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountHolder,String accountNumber,double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
    public static void displayBank() {
		System.out.println("UCO Bank");
		
	}
	
    public void deposit(double amount) {
		if(amount > 0) {
			balance+=amount;
			System.out.println("Deposited: "+amount);
		}
		else {
			System.out.println("Invalid Deposit");
		}
	}
	
	public void withdraw(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			System.out.println("Withdraw amount is : "+amount);
		}
		else if (amount <= 0) {
			System.out.println("Invalid Withdrawl");
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
	
   public void displayBalance() {
       System.out.println("Current balance: " + balance);
   }
   
   public static void main(String[] args) {
       BankAccount account = new BankAccount("Shiva", "123456945", 750.00);
      
       displayBank();
      
       account.displayBalance();
   
       account.deposit(500.00);
       account.displayBalance();
       account.withdraw(200.00);
       account.displayBalance();
       // withdrawing more then avilable balance
       account.withdraw(9000.00);
   }
}
