
import java.lang.reflect.Field;

public class AccessModifyStaticFields {

    public static void main(String[] args) {
        try {
            Class<?> cls = DBConfig.class;
            Field key = cls.getDeclaredField("key");
            key.setAccessible(true);
            String original = (String) key.get(null);
            System.out.println("Original value of key is: "+original);
            key.set(null, "JHDUHFDBB&^&*");
            String changed = (String) key.get(null);
            System.out.println("Changed value of key is: "+changed);
        } catch (Exception e) {
            System.out.println("");
        }
    }
}

class DBConfig {
    private static String key = "JHIJjfjkkfnenjkvnvfien";
}
