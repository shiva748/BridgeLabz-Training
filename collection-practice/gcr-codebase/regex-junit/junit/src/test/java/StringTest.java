import org.junit.jupiter.api.Test;
import org.learn.StringUtils;

import static org.junit.jupiter.api.Assertions.*;
public class StringTest {
    StringUtils utils = new StringUtils();

    @Test
    public void testReverse(){
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    public void testPalindrome(){
        assertTrue(utils.isPalindrome("abccba"));
    }

    @Test
    public void testUpperCase(){
        assertEquals("ABSKHFJUS", utils.toUpperCase("abSkHFjus"));
    }
}