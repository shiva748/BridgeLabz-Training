import org.junit.jupiter.api.Test;
import org.learn.Divide;

import static org.junit.jupiter.api.Assertions.*;
public class DivideTest {
    Divide divide = new Divide();
    @Test
    public void testDivide(){
        ArithmeticException exception = assertThrows(ArithmeticException.class, ()-> divide.divide(5,0));
        assertEquals("divisor cannot be zero", exception.getMessage());
    }
}
