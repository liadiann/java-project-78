package hexlet.code;

public interface Schema {
    Schema required();
    Schema minLength(int min);
    Schema contains(String subStr);
    boolean isValid(String str);
}
