package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addRules("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addRules("positive", i -> (i == null || i > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        addRules("range", i -> (i == null || (i >= min && i <= max)));
        return this;
    }
}
