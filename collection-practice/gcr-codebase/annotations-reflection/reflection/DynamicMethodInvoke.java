import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvoke {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            MathOperations math = new MathOperations();
            Class<?> cls = math.getClass();

            while (true) {
                System.out.println("Enter method name (add, subtract, multiply)");
                System.out.println("Enter \"close\" to stop");
                System.out.print("Enter: ");

                String methodName = scanner.nextLine();

                if (methodName.equalsIgnoreCase("close")) {
                    System.out.println("Thank you for using our calculator.");
                    break;
                }

                System.out.print("Enter first number: ");
                int a = scanner.nextInt();

                System.out.print("Enter second number: ");
                int b = scanner.nextInt();

                scanner.nextLine();

                Method method = cls.getMethod(methodName, int.class, int.class);

                Object result = method.invoke(math, a, b);

                System.out.println("Result: " + result);
                System.out.println("--------------------------------");
            }

            scanner.close();
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found!");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
