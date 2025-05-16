package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string().required().contains("ex").minLength(4);
        System.out.println(schema.isValid("hexlet"));
    }
}
