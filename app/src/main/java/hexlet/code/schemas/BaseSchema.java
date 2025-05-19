package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public Map<String, Predicate<T>> rules = new HashMap<>();

    public final boolean isValid(T value) {
        var check = true;
        for (var rule : rules.values()) {
            if (!rule.test(value)) {
                check = false;
                return check;
            }
        }
        return check;
    }
}
