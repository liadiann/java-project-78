package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        rules.put("required", s -> (s != null && !s.isEmpty()));
        return this;
    }

    public StringSchema minLength(int min) {
        rules.put("minLength", (s) -> (s == null || s.length() >= min));
        return this;
    }

    public StringSchema contains(String subStr) {
        rules.put("contains", (s) -> (s == null || s.contains(subStr)));
        return this;
    }
}
