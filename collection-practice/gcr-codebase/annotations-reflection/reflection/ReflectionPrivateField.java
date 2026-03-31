import java.lang.reflect.Field;

public class ReflectionPrivateField {
    public static void setAge(Person person, int newAge) {
        try {
            Field ageField = person.getClass().getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(person, newAge);
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age (via Reflection): " + modifiedAge);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Aman", 21);
        System.out.printf("Before: %s is %d years old.\n", person.getName(), person.getAge());

        setAge(person, 25);

        System.out.printf("After: %s is %d years old.\n", person.getName(), person.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
