package org.dbms.utils;

import org.dbms.annotations.FieldPrompt;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Scanner;

public class InputUtils {

    public static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    static String toSetterName(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return fieldName;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    public static <T> T read(Class<T> cls) {
        try {
            T obj = cls.getDeclaredConstructor().newInstance();
            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {

                if (field.getName().equalsIgnoreCase("id")) {
                    continue;
                }

                FieldPrompt annotation = field.getAnnotation(FieldPrompt.class);

                String message = (annotation != null)
                        ? annotation.message()
                        : "Enter " + field.getName();

                boolean allowSpaces = annotation == null || annotation.allowSpaces();
                boolean required = annotation == null || annotation.required();
                String regex = (annotation != null) ? annotation.regex() : "";

                Object value = null;

                while (true) {
                    System.out.print(message + ": ");
                    String input = sc.nextLine();

                    if (required && input.trim().isEmpty()) {
                        System.out.println("Field is required.");
                        continue;
                    }

                    if (!allowSpaces && input.contains(" ")) {
                        System.out.println("Spaces are not allowed.");
                        continue;
                    }

                    if (!regex.isEmpty() && !input.matches(regex)) {
                        System.out.println("Invalid format.");
                        continue;
                    }

                    value = convertValue(field.getType(), input);
                    break;
                }

                cls.getDeclaredMethod(
                        toSetterName(field.getName()),
                        field.getType()
                ).invoke(obj, value);
            }

            return obj;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Object convertValue(Class<?> type, String input) {

        if (type == String.class) return input;

        if (type == int.class || type == Integer.class)
            return Integer.parseInt(input);

        if (type == long.class || type == Long.class)
            return Long.parseLong(input);

        if (type == double.class || type == Double.class)
            return Double.parseDouble(input);

        if (type == boolean.class || type == Boolean.class)
            return Boolean.parseBoolean(input);

        if (type == LocalDate.class)
            return LocalDate.parse(input);

        return input;
    }
}
