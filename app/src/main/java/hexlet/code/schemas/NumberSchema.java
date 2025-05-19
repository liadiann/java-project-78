package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        rules.put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        rules.put("positive", i -> (i == null || i > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        rules.put("range", i -> (i == null || (i >= min && i <= max)));
        return this;
    }
}
