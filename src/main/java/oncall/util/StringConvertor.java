package oncall.util;

import java.util.List;

public class StringConvertor {

    private StringConvertor() {
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static List<String> convertStringArrToStringList(String[] values) {
        return List.of(values);
    }
}
