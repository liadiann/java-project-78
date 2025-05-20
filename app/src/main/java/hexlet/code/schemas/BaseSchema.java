package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private Map<String, Predicate<T>> rules = new HashMap<>();

    public final void addRules(String rule, Predicate<T> check) {
        rules.put(rule, check);
    }

    public final boolean isNullValid() {
        return !rules.containsKey("required");
    }

    public final boolean isValid(T value) {
        var check = true;
        if (value == null) {
            check = isNullValid();
            return check;
        }
        for (var rule : rules.values()) {
            if (!rule.test(value)) {
                check = false;
                return check;
            }
        }
        return check;
    }
}
