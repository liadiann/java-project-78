package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {
    @Test
    public void testStringValidator() {
        var v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid("");
        assertTrue(actual);
        schema.required();
        actual = schema.isValid(null);
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
        var schema2 = v.map();
        actual = schema2.required().sizeof(3).isValid(data);
        assertFalse(actual);
    }
}
