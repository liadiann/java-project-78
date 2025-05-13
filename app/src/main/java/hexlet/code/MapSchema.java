package hexlet.code;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<? extends Object, ? extends Object>> {

    public MapSchema required() {
        rules.put("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int capacity) {
        rules.put("sizeof", m -> m.size() == capacity);
        return this;
    }
}
