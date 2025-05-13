package hexlet.code;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        rules.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        rules.add(i -> (i == null || i > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        rules.add(i -> (i >= min && i <= max));
        return this;
    }
}
