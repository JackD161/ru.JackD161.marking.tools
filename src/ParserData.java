import java.util.ArrayList;

public class ParserData {
    public static String parseKIZ(String string) {
        StringBuilder builder = new StringBuilder();
        // печатает тип упаковки, первичка 01
        builder.append(string.substring(0, 2));
        builder.append(" ");
        // печатаем GTIN
        builder.append(string.substring(2, 16));
        builder.append(" ");
        // печатаем серийный номер
        builder.append(string.substring(18, 31));
        builder.append(" ");
        // печатаем ключ проверки
        builder.append(string.substring(33, 37));
        builder.append(" ");
        // печатаем криптохвост
        builder.append(string.substring(39));
        builder.append(" ");
        return builder.toString();
    }
}
