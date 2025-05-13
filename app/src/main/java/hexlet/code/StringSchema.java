package hexlet.code;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        rules.add((s) -> (s != null && !s.isEmpty()));
        return this;
    }

    public StringSchema minLength(int min) {
        rules.add((s) -> (s.length() >= min));
        return this;
    }

    public StringSchema contains(String subStr) {
        rules.add((s) -> (s.contains(subStr)));
        return this;
    }
}
