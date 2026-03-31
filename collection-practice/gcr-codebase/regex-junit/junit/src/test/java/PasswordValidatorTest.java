import org.junit.jupiter.api.Test;
import org.learn.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void validPassword_shouldPass() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    void password_shouldFail_whenTooShort() {
        assertFalse(validator.isValid("Ab1"));
    }

    @Test
    void password_shouldFail_whenNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    void password_shouldFail_whenNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    void password_shouldFail_whenNull() {
        assertFalse(validator.isValid(null));
    }
}
