package oncall.util;

public enum Separator {
    COMMA(",");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String[] split(String value) {
        return value.split(separator);
    }

    public String getSeparator() {
        return separator;
    }
}