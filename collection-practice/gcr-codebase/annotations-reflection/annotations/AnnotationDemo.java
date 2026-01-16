import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class BusinessLogic {

    @ImportantMethod
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void sendEmail() {
        System.out.println("Sending email...");
    }

    public void normalMethod() {
        System.out.println("This is a normal method.");
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        Class<?> cls = BusinessLogic.class;

        System.out.println("Important Methods Found:\n");

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);

                System.out.println("Method: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("---------------------------");
            }
        }
    }
}
