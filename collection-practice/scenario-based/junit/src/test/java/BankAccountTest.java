import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.learn.BankAccount;

public class BankAccountTest {

    @Test
    public void Test_Deposit_ValidAmount() {
         BankAccount account= new BankAccount(1000);
        account.Deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        BankAccount account = new BankAccount(1000);
        Exception e = assertThrows(
                IllegalArgumentException.class,
                () -> account.Deposit(-200)
        );
        assertEquals("Deposit amount cannot be negative", e.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        BankAccount account = new BankAccount(1000);
        account.Withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        BankAccount account = new BankAccount(500);
        Exception e = assertThrows(
                IllegalArgumentException.class,
                () -> account.Withdraw(800)
        );
        assertEquals("Insufficient funds", e.getMessage());
    }
}
