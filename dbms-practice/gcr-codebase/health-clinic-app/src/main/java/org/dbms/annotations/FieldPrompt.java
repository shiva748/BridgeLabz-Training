package org.dbms.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface FieldPrompt {
    String message();
    boolean allowSpaces() default true;
    boolean required() default true;
    String regex() default "";
}

