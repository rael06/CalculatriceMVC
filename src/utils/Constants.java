package utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<String, OperatorMethod> OPERATORS = new HashMap<String, OperatorMethod>() {{
        put("+", (nombre1, nombre2) -> nombre1 + nombre2);
        put("-", (nombre1, nombre2) -> nombre1 - nombre2);
        put("*", (nombre1, nombre2) -> nombre1 * nombre2);
        put("/", (nombre1, nombre2) -> nombre1 / nombre2);
    }};
}
