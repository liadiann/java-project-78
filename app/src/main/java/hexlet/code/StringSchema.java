package hexlet.code;

public class StringSchema implements Schema {
    private boolean needRequired = false;
    private int needMinLength = 0;
    private String needContains = "";


    @Override
    public Schema required() {
        needRequired = true;
        return this;
    }

    @Override
    public Schema minLength(int min) {
        needMinLength = min;
        return this;
    }

    @Override
    public Schema contains(String subStr) {
        needContains = subStr;
        return this;
    }

    @Override
    public boolean isValid(String str) {
        boolean check = true;
        if ((needRequired && (str == null || str.equals("")))
            || str.length() < needMinLength || !str.contains(needContains)) {
            check = false;
        }
        return check;
    }
}
