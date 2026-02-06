import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Shiva");
        BankAccount account2 = new BankAccount("Anushka");

        Thread transaction1 = new Thread(new Transaction(account1, 9000));
        Thread transaction2 = new Thread(new Transaction(account2, 1000));
        Thread transaction3 = new Thread(new Transaction(account1, 1500));
        Thread transaction4 = new Thread(new Transaction(account2, 200));
        Thread transaction5 = new Thread(new Transaction(account1, 3000)); // added one more

        transaction1.start();
        transaction2.start();
        transaction3.start();
        transaction4.start();
        transaction5.start();
    }
}

class BankAccount {
    private String holderName;
    private int balance;

    public BankAccount(String holderName){
        this.holderName = holderName;
        this.balance = 10000;
    }

    public synchronized void withDraw(int amount) {
        if(balance < amount) {
            System.out.printf(
                    "withdraw request of $%d done by %s is not processable because of insufficient funds\n",
                    amount, holderName
            );
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        balance -= amount;
        System.out.printf(
                "%s withdraw $%d at %s and remaning balance is $%d\n",
                holderName, amount, LocalDateTime.now().format(formatter).toString(), balance
        );
    }

    public String getHolderName() {
        return holderName;
    }

    public int getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    private BankAccount bankAccount;
    private int amountToWithdraw;

    public Transaction(BankAccount bankAccount, int amountToWithdraw){
        this.bankAccount = bankAccount;
        this.amountToWithdraw = amountToWithdraw;
    }

    @Override
    public void run() {
        bankAccount.withDraw(amountToWithdraw);
    }
}
