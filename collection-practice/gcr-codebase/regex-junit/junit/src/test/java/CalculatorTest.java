import org.junit.jupiter.api.Test;
import org.learn.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator c = new Calculator();
    @Test
    public void testAdd() {
        assertEquals(3, c.add(1, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, c.sub(8, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, c.multiply(3, 4));
    }

    @Test
    public void testDivide() {
            assertEquals(10, c.divide(50, 5));
    }

    @Test
    public void divideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> c.divide(10, 0));
        assertEquals("Division by zero not allowed", exception.getMessage());
    }
}
