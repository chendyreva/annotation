package ru.geekbrains;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
public @interface Entity {
    String tableName() default "";
}
