package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    List<Predicate<T>> rules = new ArrayList<>();

    public boolean isValid(T value) {
        var check = true;
        for (var rule : rules) {
            if (!rule.test(value)) {
                check = false;
                return check;
            }
        }
        return check;
    }
}
