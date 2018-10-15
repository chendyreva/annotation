package ru.geekbrains;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Method {

    public static void main(String[] args) {
        Map<String, Object> record = new HashMap<>();
        record.put("cat1", "1200");
        record.put("kitkat", "128");
        record.put("toys", "500");

        Cat cat = process(record);
        recreateClass(Cat.class);
        processConstructors(Cat.class);
    }

    @LogParams
    private static void processConstructors(Class<Cat> catClass) {
         Constructor<Cat>[] constructors = (Constructor<Cat>[]) catClass.getConstructors();
            for (Constructor<Cat> constructor : constructors) {
                if (constructor.getParameterCount() == 0) {
                    try {
                        Cat newInstance = constructor.newInstance();
                        System.out.println("Price = " + newInstance.getPrice());
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Arrays.toString(constructor.getParameterTypes()));
                }
            }
            try {
                Cat cat1 = catClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        private static void recreateClass(Class<Cat> catClass) {
            int modifiers = catClass.getModifiers();
            boolean isPublic = Modifier.isPublic(modifiers);
            boolean isFinal = Modifier.isFinal(modifiers);
            System.out.println(catClass.getPackage() + ";");
            System.out.println((isPublic ? "public" : "") + " "
                    + (isFinal ? " final class " : " class ")
                    + catClass.getSimpleName());
        }
    public static Cat process(Map<String, Object> record) {
        Class<? extends Cat> goodClass = Cat.class;
        double price = 0.0;
        String goodName = "";
        String barcode = null;
        for (Field field : goodClass.getDeclaredFields()) {
            String name = field.getName();
            Object value = record.get(name);
            if ("name".equals(name)) {
                goodName = (String) value;
            } else if ("price".equals(name)) {
                price = (double) value;
            } else {
                Column annotation = field.getAnnotation(Column.class);
                if (annotation != null) {
                    String field1 = annotation.field();
                    barcode = (String) record.get(field1);
                }
            }
            System.out.println("Process " + name + " field");
        }
        Cat cat = new Cat(goodName, price);
        cat.setBarcode(barcode);
        return cat;
    }
}



