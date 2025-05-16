package hexlet.code;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public <K, V> MapSchema<K, V> map() {
        return new MapSchema<>();
    }
}
