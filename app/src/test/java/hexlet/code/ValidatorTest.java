package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {
    @Test
    public void testStringValidator() {
        var v = new Validator();
        Schema schema = v.string();
        var expected = true;
        var actual = schema.isValid("");
        assertEquals(expected, actual);
        schema.required();
        expected = false;
        actual = schema.isValid(null);
        assertEquals(expected, actual);
        expected = true;
        actual = schema.isValid("hexlet");
        assertEquals(expected, actual);
        schema.minLength(5);
        expected = true;
        actual = schema.isValid("hexlet");
        assertEquals(expected, actual);
        expected = false;
        actual = schema.isValid("aa");
        assertEquals(expected, actual);
        schema.contains("ex");
        expected = true;
        actual = schema.isValid("hexlet");
        assertEquals(expected, actual);
        expected = false;
        actual = schema.isValid("aa");
        assertEquals(expected, actual);
        schema.required().minLength(3).contains("hex");
        expected = true;
        actual = schema.isValid("hexlet");
    }
}
