package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    Map<String, Predicate<T>> rules = new HashMap<>();

    public boolean isValid(T value) {
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
