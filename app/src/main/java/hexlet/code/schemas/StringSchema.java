package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addRules("required", s -> (s != null && !s.isEmpty()));
        return this;
    }

    public StringSchema minLength(int min) {
        addRules("minLength", (s) -> (s == null || s.length() >= min));
        return this;
    }

    public StringSchema contains(String subStr) {
        addRules("contains", (s) -> (s == null || s.contains(subStr)));
        return this;
    }
}
