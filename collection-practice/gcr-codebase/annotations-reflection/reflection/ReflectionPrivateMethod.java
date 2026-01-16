import java.lang.reflect.Method;

public class ReflectionPrivateMethod {

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();

            Class cls = calc.getClass();

            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            method.setAccessible(true);

            int result = (int) method.invoke(calc, 5, 4);

            System.out.println("Result of multiply(5, 4): " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Calculator {

    private int multiply(int a, int b) {
        return a * b;
    }
}
