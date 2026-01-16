
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnoteTodo {
    public static void main(String[] args) {
        Class<?> cls = Bank.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Todo.class)){
                System.out.println("// === === === === //");
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: "+method.getName());
                System.out.println("Task: "+todo.task());
                System.out.println("Assigned to: "+todo.assignedTo());
                System.out.println("Priority: "+todo.priority());
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority();
}

class Bank{
    @Todo(task="should debit money from specified account", assignedTo="Shiva", priority="HIGH")
    public void debit(int account, int amount){}

    @Todo(task="should credit money to specified account", assignedTo="Sajal", priority="HIGH")
    public void credit(int account, int amount){}

}
