public class ParserData {
    public static String parseKIZ(String string) {
        // печатает тип упаковки 2 символа
        return string.substring(0, 2) +
                " " +
                // печатаем GTIN 14 символов
                string.substring(2, 16) +
                " " +
                // печатаем серийный номер 13 символов
                string.substring(18, 31) +
                " " +
                // печатаем ключ проверки 4 символа
                string.substring(33, 37) +
                " " +
                // печатаем криптохвост 44 символа
                string.substring(39) +
                " ";
    }
    public static String ejectSgtin(String string) {
        return string.substring(2, 16) +
                string.substring(18, 31);
    }
}
