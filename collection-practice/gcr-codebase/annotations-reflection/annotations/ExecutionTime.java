import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class ExecutionTime {
    public static void main(String[] args){
        TaskService service = new TaskService();
        Class<?> cls = TaskService.class;
        Arrays.stream(cls.getDeclaredMethods()).forEach((method)->{
            try {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();

                method.invoke(service);

                long end = System.nanoTime();

                long duration = (end - start) / 1000000; // convert to milliseconds

                System.out.println("Method: " + method.getName());
                System.out.println("Execution Time: " + duration + " ms");
                System.out.println("---------------------------");
            }
            } catch (Exception e) {
                System.out.println("Error occured: "+e.getMessage());
            }
        });
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}

class TaskService{

     @LogExecutionTime
    public void fastTask() throws InterruptedException {
        Thread.sleep(10);
    }

    
    @LogExecutionTime
    public void slowTask() throws InterruptedException {
        Thread.sleep(50);
    }
    
    @LogExecutionTime
    public void verySlowTask() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void sayHello(){
        System.out.println("Hello there.");
    }
}