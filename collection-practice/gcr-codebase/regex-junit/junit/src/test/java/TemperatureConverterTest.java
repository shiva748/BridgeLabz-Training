import org.junit.jupiter.api.Test;
import org.learn.TemperatureConverter;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void celsiusToFahrenheit_shouldConvertCorrectly() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
        assertEquals(212, converter.celsiusToFahrenheit(100));
    }

    @Test
    void fahrenheitToCelsius_shouldConvertCorrectly() {
        assertEquals(0, converter.fahrenheitToCelsius(32));
        assertEquals(100, converter.fahrenheitToCelsius(212));
    }

    @Test
    void conversion_shouldHandleNegativeValues() {
        assertEquals(-40, converter.celsiusToFahrenheit(-40));
        assertEquals(-40, converter.fahrenheitToCelsius(-40));
    }
}
