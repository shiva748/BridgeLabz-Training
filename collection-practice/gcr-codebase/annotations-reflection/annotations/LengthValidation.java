
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class LengthValidation {

    public static void main(String[] args) {
        User user1 = new User("Shiva");
        User user2 = new User("Aman Pratap");
    }
}

class User {
    @MaxLength(Value=5)
    private String name;

    public User(String name) {
        this.name = name;
        validateMaxLength();
    }

    private void validateMaxLength() {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);

                try {
                    Object value = field.get(this);
                    if (value instanceof String) {
                        String str = (String) value;
                        if (str.length() > maxLength.Value()) {
                            throw new IllegalArgumentException(
                                    "Field '" + field.getName() + "' exceeds max length of " + maxLength.Value()
                            );
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int Value();
}
