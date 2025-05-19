package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addRules("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int capacity) {
        addRules("sizeof", m -> m.size() == capacity);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <V> void shape(Map<?, BaseSchema<V>> schemas) {
        addRules("shape", m -> {
            var check = true;
            for (var entry : schemas.entrySet()) {
                var value = m.get(entry.getKey());
                check = entry.getValue().isValid((V) value);
                if (!check) {
                    return check;
                }
            }
            return check;
        });
    }
}
