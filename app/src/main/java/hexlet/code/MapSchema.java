package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    private Map<K, BaseSchema<V>> schemasForValues = new HashMap<>();
    public MapSchema<K, V> required() {
        rules.put("required", Objects::nonNull);
        return this;
    }

    public MapSchema<K, V> sizeof(int capacity) {
        rules.put("sizeof", m -> m.size() == capacity);
        return this;
    }

    public void shape(Map<K, BaseSchema<V>> schemas) {
        rules.put("shape", m -> true);
        schemasForValues.putAll(schemas);
    }

    @Override
    public boolean isValid(Map<K, V> data) {
        var check = true;
        for (var rule : rules.values()) {
            if (!rule.test(data)) {
                check = false;
                return check;
            }
        }
        if (!schemasForValues.isEmpty()) {
            for (var entry : data.entrySet()) {
                check = schemasForValues.get(entry.getKey()).isValid(entry.getValue());
                if (!check) {
                    return check;
                }
            }
        }
        return check;
    }
}
