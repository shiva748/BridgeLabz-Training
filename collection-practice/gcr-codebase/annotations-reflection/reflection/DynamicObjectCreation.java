
import java.lang.reflect.Constructor;

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> cls = Student.class;
            Constructor constructor = cls.getConstructor(String.class);
            Student student = (Student) constructor.newInstance("Shiva");
            System.out.println(student.name);
        } catch (Exception e) {
            System.out.println("error occured: "+e.getMessage());
        }
    }
}

class Student{
    public String name;

    public Student(String name){
        this.name = name;
    }
}
