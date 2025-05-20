package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {
    @Test
    public void testStringValidator() {
        var v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid("");
        assertTrue(actual);
        actual = schema.isValid(null);
        assertTrue(actual);
        schema.required();
        actual = schema.isValid(null);
        assertFalse(actual);
        actual = schema.isValid("");
        assertFalse(actual);
        actual = schema.isValid("hexlet");
        assertTrue(actual);
        schema.minLength(5);
        actual = schema.isValid("hexlet");
        assertTrue(actual);
        actual = schema.isValid("aa");
        assertFalse(actual);
        schema.contains("ex");
        actual = schema.isValid("hexlet");
        assertTrue(actual);
        actual = schema.isValid("aa");
        assertFalse(actual);
        schema.required().minLength(3).contains("hex");
        actual = schema.isValid("hexlet");
        assertTrue(actual);
        schema.minLength(10).contains("he");
        actual = schema.isValid("hexlet");
        assertFalse(actual);
    }

    @Test
    public void testNumberValidator() {
        var v = new Validator();
        var schema = v.number();
        var actual = schema.isValid(5);
        assertTrue(actual);
        actual = schema.isValid(null);
        assertTrue(actual);
        actual = schema.positive().isValid(null);
        assertTrue(actual);
        schema.required();
        actual = schema.isValid(null);
        assertFalse(actual);
        actual = schema.isValid(-10);
        assertFalse(actual);
        actual = schema.isValid(0);
        assertFalse(actual);
        schema.range(5, 10);
        actual = schema.isValid(5);
        assertTrue(actual);
        actual = schema.isValid(10);
        assertTrue(actual);
        actual = schema.isValid(3);
        assertFalse(actual);
        actual = schema.isValid(14);
        assertFalse(actual);
    }

    @Test
    public void testMapValidator() {
        var v = new Validator();
        var schema = v.map();
        var actual = schema.isValid(null);
        assertTrue(actual);
        schema.required();
        actual = schema.isValid(null);
        assertFalse(actual);
        actual = schema.isValid(new HashMap<>());
        assertTrue(actual);
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        actual = schema.isValid(data);
        assertTrue(actual);
        schema.sizeof(2);
        actual = schema.isValid(data);
        assertFalse(actual);
        data.put("key2", "value2");
        actual = schema.isValid(data);
        assertTrue(actual);
        schema.sizeof(3);
        actual = schema.isValid(data);
        assertFalse(actual);
        var schema2 = v.map();
        actual = schema2.required().sizeof(3).isValid(data);
        assertFalse(actual);
    }

    @Test
    public void testMapValues() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        var actual = schema.isValid(human1);
        assertTrue(actual);
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        actual = schema.isValid(human2);
        assertFalse(actual);
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anne");
        human3.put("lastName", "S");
        actual = schema.isValid(human3);
        assertFalse(actual);
        var schema2 = v.map();
        Map<String, BaseSchema<Integer>> schemas2 = new HashMap<>();
        schemas2.put("department", v.number().required());
        schemas2.put("salary", v.number().required().range(20000, 40000));
        schema2.shape(schemas2);
        Map<String, Integer> human4 = new HashMap<>();
        human4.put("department", 30000);
        human4.put("salary", 50000);
        actual = schema2.isValid(human4);
        assertFalse(actual);
    }
}
