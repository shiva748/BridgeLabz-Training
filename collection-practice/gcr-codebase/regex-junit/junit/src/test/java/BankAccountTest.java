import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learn.BankAccount;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void withdraw_shouldFail_whenInsufficientFunds() {
        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(1500)
        );

        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void deposit_shouldFail_whenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
    }

    @Test
    void withdraw_shouldFail_whenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-200));
    }
}
