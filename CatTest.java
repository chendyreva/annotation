package ru.geekbrains;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CatTest {
    private Map<String, Object> record;
    private double value = 3.1415;
    @Before
    public void init() {
        record = new HashMap<>();
        record.put("cat", "red");
        record.put("cat1", "Vasya");
        record.put("cat2", value);
    }
    @Test
    public void testProcessPrice() {
        Method method = new Method();
        Cat cat = method.process(record);
        assertEquals(value, cat.getPrice(), 0.00001);
    }
    @Test
    public void testProcessName() {
        Method m = new Method();
        Cat cat = m.process(record);
        assertEquals(record.get("cat"), cat.getName());
    }
    @Test
    public void testProcessBarcode() {
        Method m = new Method();
        Cat cat = m.process(record);
        assertEquals(record.get("cat1"), cat.getBarcode());
    }
    @Test
    public void testProcessIsNotNull() {
        Method m = new Method();
        Cat cat = m.process(record);
        assertNotNull(cat);
    }
}